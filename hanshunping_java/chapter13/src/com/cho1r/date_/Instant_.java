package com.cho1r.date_;

import java.time.LocalDateTime;
import java.util.Date;
import java.time.Instant;

/**
 * Author cho1r
 * 2021-11-30 030 09:44 上午
 */
public class Instant_ {
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println(now);

        // date --> instant
        Date date = Date.from(now);
        // instant --> date
        Instant instant = date.toInstant();

        LocalDateTime localDateTime = LocalDateTime.now().minusYears(10);
        System.out.println(localDateTime);
    }
}
