package com.yakumo.pubacc.service;

import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.thoughtworks.xstream.XStream;
import com.yakumo.pubacc.domain.sendMsg.Article;
import com.yakumo.pubacc.domain.sendMsg.BaseSendMsg;
import com.yakumo.pubacc.domain.sendMsg.NewsSendMsg;
import com.yakumo.pubacc.domain.sendMsg.TextSendMsg;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author cho1r
 * 2022/03/29 20:49
 */
@Component
public class WxService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DealSendMsgService dealSendMsgService;

    @Value("${authtoken}")
    private String authtoken;

    public boolean authCheck(Map<String, String> params) {
        /**
         * signature	微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
         * timestamp	时间戳
         * nonce	随机数
         * echostr	随机字符串
         *
         * 开发者通过检验signature对请求进行校验（下面有校验方式）。若确认此次GET请求来自微信服务器，
         * 请原样返回 echostr 参数内容，则接入生效，成为开发者成功，否则接入失败。加密/校验流程如下：
         *
         * 1）将token、timestamp、nonce 三个参数进行字典序排序
         * 2）将三个参数字符串拼接成一个字符串进行sha1加密
         * 3）开发者获得加密后的字符串可与 signature 对比，标识该请求来源于微信
         */

        String[] arr = {authtoken, params.get("timestamp"), params.get("nonce")};
        Arrays.sort(arr);

        String str = arr[0] + arr[1] + arr[2];
        // 1. 手写 sha1 摘要算法
//        String digest = sha1(str);
        // or 2. 使用 hutool
        String sha1Hex = DigestUtil.sha1Hex(str);

        return sha1Hex.equalsIgnoreCase(params.get("signature"));
    }

    /**
     * 手写摘要算法 SHA-1
     *
     * @param str
     * @return
     */
    private String sha1(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("sha1");
            byte[] digest = md.digest(str.getBytes());
            char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                // 可使用 无符号位移 >>>, 则不需要 &15
//                sb.append(chars[(b >> 4) & 15]);
                sb.append(chars[b >>> 4]);
                sb.append(chars[b & 15]);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 从 ServletInputStream 中解析 xml 为 map
     *
     * @param inputStream
     * @return
     */
    public Map<String, String> parseRecvMsg(ServletInputStream inputStream) {
        Map<String, String> map = new HashMap<>();
        SAXReader reader = new SAXReader();
        try {
            // 读取输入流, 获取文档对象
            Document document = reader.read(inputStream);
            // 获取根节点
            Element root = document.getRootElement();
            // 获取所有子节点
            List<Element> elements = root.elements();
            for (Element element : elements) {
                map.put(element.getName(), element.getStringValue());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return map;
    }

    /**
     * 根据 MsgType 回复相应的消息
     *
     * @param recvMsg
     * @return
     */
    public String getReplyXml(Map<String, String> recvMsg) {
        String msgType = recvMsg.get("MsgType");
        BaseSendMsg sendMsg = null;
        switch (msgType) {
            case "text":
                sendMsg = dealSendMsgService.dealTextMsg(recvMsg);
                break;
            case "image":
                sendMsg = dealSendMsgService.dealImageMsg(recvMsg);
                break;
            case "voice":
                break;
            case "video":
                break;
            case "music":
                break;
            case "news":
                break;
            case "event":
                sendMsg = dealSendMsgService.dealEventMsg(recvMsg);
                break;
            default:
                break;
        }

        return bean2xml(sendMsg);
    }

    /**
     * 消息对象 to xml 字符串
     *
     * @param bean
     * @return
     */
    private String bean2xml(BaseSendMsg bean) {
        XStream xStream = new XStream();
        // 其他类对象依次添加
        xStream.processAnnotations(TextSendMsg.class);
        xStream.processAnnotations(NewsSendMsg.class);
        xStream.processAnnotations(Article.class);
        String xml = xStream.toXML(bean);
        System.out.println(xml);
        return xml;
    }


    /**
     * 通过code换取网页授权 access_token
     *
     * @param code
     * @return
     */
    public String get_auth_access_token(String code) {
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";
        url = String.format(url, "wx66a6c2d781ec58c8", "8f36d9d1ebf357b6e8b09d44ed7830d8", code);
        String jsonstr = restTemplate.getForObject(url, String.class);
        System.out.println(jsonstr);
        return jsonstr;
    }

    /**
     * 使用 code 获取 access_token, openid 后获取用户信息
     *
     * @param code
     * @return
     */
    public String getUserInfo(String code) {
        String jsonstr = get_auth_access_token(code);
        JSONObject json = JSONUtil.parseObj(jsonstr);
        String access_token = json.getStr("access_token");
        String openid = json.getStr("openid");

        String url = "https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN";
        url = String.format(url, access_token, openid);

        String user = restTemplate.getForObject(url, String.class);
        System.out.println(user);
        return user;
    }
}
