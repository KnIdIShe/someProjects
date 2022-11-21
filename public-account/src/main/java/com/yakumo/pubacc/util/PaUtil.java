package com.yakumo.pubacc.util;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.yakumo.pubacc.domain.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Author cho1r
 * 2022/03/31 11:42
 */
@Component
public class PaUtil {
    private AccessToken accessToken;

    @Value("${get_access_token_url}")
    private String get_access_token_url;

    @Autowired
    public RestTemplate restTemplate;


    /**
     * 内部使用, 调用微信服务器获取 accessToken
     */
    private void getAccessTokenFromWX() {
        String jsonStr = restTemplate.getForObject(get_access_token_url, String.class);
        JSONObject jsonObject = JSONUtil.parseObj(jsonStr);
        accessToken = new AccessToken(jsonObject.getStr("access_token"), jsonObject.getInt("expires_in"));
    }

    /**
     * 外部使用, 过期则重新获取 token 并返回
     *
     * @return
     */
    public String getAccessToken() {
        if (accessToken == null || accessToken.isExpired()) {
            getAccessTokenFromWX();
        }
        return accessToken.getAccessToken();
    }
}
