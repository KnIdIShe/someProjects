package com.cho1r.enum_;

/**
 * Author cho1r
 * 2021-11-24 024 06:19 下午
 */
public class EnumMethod {
    public static void main(String[] args) {
        Season autumn = Season.AUTUMN;
        System.out.println(autumn.name());
        System.out.println(autumn.ordinal());

        for (Season value : Season.values()) {
            System.out.println(value);
        }

        // 先去Season中找, 没找到则报错
        Season spring = Season.valueOf("SPRING");
        System.out.println(spring);
        System.out.println(spring == Season.SPRING);

        // 比较的是位置号(编号)
        System.out.println(Season.AUTUMN.compareTo(Season.SUMMER));
    }
}
