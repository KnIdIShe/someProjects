package com.yakumo.pubacc.service;

import com.yakumo.pubacc.util.PaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Author cho1r
 * 2022/03/31 20:29
 */
@Component
public class TemplateMsgService {
    @Autowired
    private PaUtil util;

    // 设置所属行业 url, POST
    private final String set_industry_url = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=";
    // 获取设置的行业信息 url, GET
    private final String get_industry_url = "https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=";
    // 发送模板消息 url, POST
    private final String send_templateMsg_url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";

    /**
     * 设置所属行业
     */
    public void setIndustry() {
        String data = "{\n" +
                "    \"industry_id1\":\"1\",\n" +
                "    \"industry_id2\":\"2\"\n" +
                "}";
        String accessToken = util.getAccessToken();
        String resp = util.restTemplate.postForObject(set_industry_url + accessToken, data, String.class);
        System.out.println(resp);
    }

    /**
     * 获取设置的行业信息
     */
    public void getIndustry() {
        String accessToken = util.getAccessToken();
        String resp = util.restTemplate.getForObject(get_industry_url + accessToken, String.class);
        System.out.println(resp);
    }

    public void sendTemplateMsg() {
        String data = "{\n" +
                "  \"touser\": \"o6NTJ5_Zarbe4TLdM5a1cyEelyCk\",\n" +
                "  \"template_id\": \"CJDlG25Lk3mva5bsTILp0abBSOj6gPoXCAc9hD8Ul-c\",\n" +
                "  \"url\": \"http://weixin.qq.com/download\",\n" +
                "  \"data\": {\n" +
                "    \"first\": {\n" +
                "      \"value\": \"恭喜你购买成功！\",\n" +
                "      \"color\": \"#173177\"\n" +
                "    },\n" +
                "    \"company\": {\n" +
                "      \"value\": \"巧克力\",\n" +
                "      \"color\": \"#173177\"\n" +
                "    },\n" +
                "    \"time\": {\n" +
                "      \"value\": \"39.8元\",\n" +
                "      \"color\": \"#173177\"\n" +
                "    },\n" +
                "    \"result\": {\n" +
                "      \"value\": \"2014年9月22日\",\n" +
                "      \"color\": \"#173177\"\n" +
                "    },\n" +
                "    \"remark\": {\n" +
                "      \"value\": \"欢迎再次购买！\",\n" +
                "      \"color\": \"#173177\"\n" +
                "    }\n" +
                "  }\n" +
                "}";

        String accessToken = util.getAccessToken();
        String resp = util.restTemplate.postForObject(send_templateMsg_url + accessToken, data, String.class);
        System.out.println(resp);
    }
}
