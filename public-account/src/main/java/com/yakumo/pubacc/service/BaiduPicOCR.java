package com.yakumo.pubacc.service;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baidu.aip.ocr.AipOcr;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * Author cho1r
 * 2022/03/31 15:29
 * https://ai.baidu.com/ai-doc/OCR/Ikibizxql
 */
@Component
public class BaiduPicOCR {
    //设置APPID/AK/SK
    public final String APP_ID = "25881372";
    public final String API_KEY = "nDYXU1o4Istcc5kTkXocnsV7";
    public final String SECRET_KEY = "ysSfscMu9PtaKQhHBNFtu5GaDnxBpvEg";

    public String getOcrWords(String picUrl) {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
//        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        String path = picUrl;

        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("language_type", "CHN_ENG");
        options.put("detect_direction", "true");
        options.put("detect_language", "true");
        options.put("probability", "true");

        // 参数为本地图片路径
//        org.json.JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
        // 通用文字识别, 图片参数为远程url图片
        org.json.JSONObject res = client.basicGeneralUrl(picUrl, options);

        // org.json.JSONObject -> cn.hutool.json.JSONObject
        String jsonStr = res.toString();

        List<JSONObject> wordsArray = JSONUtil.parseObj(jsonStr).getBeanList("words_result", JSONObject.class);

        StringBuilder stringBuilder = new StringBuilder();
        for (JSONObject words : wordsArray) {
            stringBuilder.append(words.getStr("words")).append("\n");
        }

        String result = stringBuilder.toString();
        System.out.println(result);
        return result;
    }
}
