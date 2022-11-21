package com.yakumo.servlet.utils;

import javax.servlet.http.Cookie;

/**
 * Author cho1r
 * 18/1/2022 下午3:33
 */
public class CookieUtils {
    public static Cookie getCookie(String name, Cookie[] cookies) {
        if (name == null || name.length() == 0 || cookies == null || cookies.length == 0) {
            return null;
        }

        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                return cookie;
            }
        }

        return null;
    }
}
