package com.cho1r.date_;

import java.util.Calendar;

/**
 * Author cho1r
 * 2021-11-29 029 07:17 下午
 */
public class Calender01 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        // Calendar.HOUR_OF_DAY 24小时进制
        // Calendar.HOUR 12小时进制
        System.out.println(String.format("%s-%s-%s %s:%s:%s", calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND)));


    }
}
