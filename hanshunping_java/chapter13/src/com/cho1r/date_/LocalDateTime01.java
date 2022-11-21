package com.cho1r.date_;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Author cho1r
 * 2021-11-29 029 07:31 下午
 */
public class LocalDateTime01 {
    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
        System.out.println(dateTimeFormatter.format(localDateTime));

    }
}
