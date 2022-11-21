package com.yakumo.i18n;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Author cho1r
 * 21/1/2022 下午4:18
 */
public class I18nTest {

    @Test
    public void testLocal() {
        System.out.println(Locale.getDefault());

//        for (Locale availableLocale : Locale.getAvailableLocales()) {
//            System.out.println(availableLocale);
//        }

        System.out.println(Locale.CHINA);
        System.out.println(Locale.US);
    }

    @Test
    public void testI18n() throws UnsupportedEncodingException {
//        Locale locale = Locale.US;
        Locale locale = Locale.CHINA;

        ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale);

        System.out.println(bundle.getString("username"));
        System.out.println(bundle.getString("password"));
        System.out.println(bundle.getString("sex"));
        System.out.println(bundle.getString("age"));
    }
}
