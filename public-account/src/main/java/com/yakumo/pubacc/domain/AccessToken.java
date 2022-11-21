package com.yakumo.pubacc.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author cho1r
 * 2022/03/30 21:34
 */
@Data
@NoArgsConstructor
public class AccessToken {
    private String accessToken;
    private long expiresTime;

    public AccessToken(String accessToken, int expires_in) {
        this.accessToken = accessToken;
        this.expiresTime = System.currentTimeMillis() + expires_in * 1000;
    }

    /**
     * 判断 token 是否过期
     * @return
     */
    public boolean isExpired() {
        return System.currentTimeMillis() > expiresTime;
    }
}
