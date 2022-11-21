package com.yakumo.base64;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Author cho1r
 * 20/1/2022 下午4:22
 */
public class Base64Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String encoded = Base64.getEncoder().encodeToString("华盛顿".getBytes(StandardCharsets.UTF_8));
        System.out.println(encoded);

        System.out.println(new String(Base64.getDecoder().decode(encoded), StandardCharsets.UTF_8));
    }
}
