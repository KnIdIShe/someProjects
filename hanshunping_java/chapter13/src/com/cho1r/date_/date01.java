package com.cho1r.date_;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author cho1r
 * 2021-11-29 029 06:46 下午
 */
public class date01 {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println(date);// 当前时间

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd a h:mm:ss E");
        System.out.println(simpleDateFormat.format(date));

        System.out.println(simpleDateFormat.parse("2030-02-23 上午 3:23:34 星期一"));// 星期会自动转换成正确的
    }
}
