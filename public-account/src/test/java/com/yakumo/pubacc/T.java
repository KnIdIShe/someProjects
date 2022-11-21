package com.yakumo.pubacc;


import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.json.JSONObject;
import com.yakumo.pubacc.domain.sendMsg.TextSendMsg;
import com.thoughtworks.xstream.XStream;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Author cho1r
 * 2022/03/30 14:49
 */
public class T {
    @Test
    void t() {
        char[] arr = {'a', 'g', 'd'};
        Arrays.sort(arr);
        System.out.println(arr);
    }

    @Test
    void t2() {
        XStream xStream = new XStream();
        xStream.processAnnotations(TextSendMsg.class);
        HashMap<String, String> map = new HashMap<>();
        map.put("ToUserName", "a");
        map.put("FromUserName", "b");
        TextSendMsg textReplyMsg = new TextSendMsg(map, "哈哈");
        String xml = xStream.toXML(textReplyMsg);
        System.out.println(xml);
    }

    @Test
    void t3() {
        String sha1Hex = DigestUtil.sha1Hex("aaa");
        System.out.println(sha1Hex);
    }

    @Test
    void t4() {
        JSONObject json = new JSONObject("{\n" +
                "  \"code\": 200,\n" +
                "  \"msg\": \"success\",\n" +
                "  \"newslist\": [\n" +
                "    {\n" +
                "      \"reply\": \"亲爱的主银你好，我叫小天，性别男，来自湖北，正在从事互联网工作。金牛座的我，爱好摄影也喜欢和人类做朋友！\",\n" +
                "      \"datatype\": \"text\"\n" +
                "    }\n" +
                "  ]\n" +
                "}");

        String resp = json.getByPath("newslist[0].reply", String.class);
        System.out.println(resp);
    }

    @Test
    public void t6() {

    }
}
