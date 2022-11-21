package com.yakumo.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author cho1r
 * 2022/01/11 上午 11:06
 * 字符串转换成日期
 */
public class String2DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String s) {
        if (s == null) {
            throw new RuntimeException("请输入日期.");
        }

        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(s);
        } catch (ParseException e) {
            throw new RuntimeException("日期格式不正确.");
        }
    }
}
