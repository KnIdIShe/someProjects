package com.yakumo.pubacc.service;

import cn.hutool.json.JSONObject;
import com.yakumo.pubacc.domain.sendMsg.Article;
import com.yakumo.pubacc.domain.sendMsg.BaseSendMsg;
import com.yakumo.pubacc.domain.sendMsg.NewsSendMsg;
import com.yakumo.pubacc.domain.sendMsg.TextSendMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Map;

/**
 * Author cho1r
 * 2022/03/30 11:38
 */
@Component
public class DealSendMsgService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private BaiduPicOCR baiduPicOCR;

    @Value("${chatRobotUrl}")
    private String chatRobotUrl;

    public BaseSendMsg dealTextMsg(Map<String, String> recvMsg) {
        String content = recvMsg.get("Content");
        System.out.println(content);
        if (content.equals("图文")) {
            ArrayList<Article> articles = new ArrayList<>();
            articles.add(new Article("title", "description", "https://www.bing.com//th?id=OHR.BeltedGalloway_EN-US0423647307_1920x1080.jpg", "https://www.bing.com/"));
            return new NewsSendMsg(recvMsg, articles);
        }
        if (content.equals("登录")) {
            String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx66a6c2d781ec58c8&redirect_uri=https://64197077.cpolar.cn/userinfo&response_type=code&scope=snsapi_userinfo#wechat_redirect";
            return new TextSendMsg(recvMsg, "<a href='" + url + "'>点击这里登录</a>");
        }
        String resp = chat(content);
        return new TextSendMsg(recvMsg, resp);
    }

    /**
     * 调用聊天机器人API
     *
     * @param content
     * @return
     */
    private String chat(String content) {
        String encodedContent = null;
        try {
            encodedContent = URLEncoder.encode(content, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        JSONObject json = restTemplate.getForObject(chatRobotUrl + encodedContent, JSONObject.class);
        /**
         * {
         *   "code": 200,
         *   "msg": "success",
         *   "newslist": [
         *     {
         *       "reply": "亲爱的主银你好，我叫小天，性别男，来自湖北，正在从事互联网工作。金牛座的我，爱好摄影也喜欢和人类做朋友！",
         *       "datatype": "text"
         *     }
         *   ]
         * }
         */
        assert json != null;
        String resp = json.getByPath("newslist[0].reply", String.class);
        System.out.println(resp);
        return resp;
    }

    public BaseSendMsg dealEventMsg(Map<String, String> recvMsg) {
        String event = recvMsg.get("Event");
        switch (event) {
            case "CLICK":
                return dealClick(recvMsg);
            case "VIEW":
                return dealView(recvMsg);
            default:
                break;
        }
        return null;
    }

    /**
     * 处理点击事件
     *
     * @param recvMsg
     * @return
     */
    private BaseSendMsg dealClick(Map<String, String> recvMsg) {
        String eventKey = recvMsg.get("EventKey");
        switch (eventKey) {
            // 第一个菜单
            case "11":
                return new TextSendMsg(recvMsg, "u clicked button 1");
            case "32":
                return new TextSendMsg(recvMsg, "u clicked button 3.1");
            default:
                break;
        }
        return null;
    }

    private BaseSendMsg dealView(Map<String, String> recvMsg) {
        return null;
    }

    /**
     * 图片 OCR
     *
     * @param recvMsg
     * @return
     */
    public BaseSendMsg dealImageMsg(Map<String, String> recvMsg) {
        String content = baiduPicOCR.getOcrWords(recvMsg.get("PicUrl"));
        return new TextSendMsg(recvMsg, content);
    }
}
