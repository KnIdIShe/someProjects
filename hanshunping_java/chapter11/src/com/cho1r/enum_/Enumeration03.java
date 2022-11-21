package com.cho1r.enum_;

/**
 * Author cho1r
 * 2021-11-24 024 03:11 下午
 * 自定义枚举类
 */
public class Enumeration03 {
    public static void main(String[] args) {
        System.out.println(Season.AUTUMN);
        System.out.println(Season.SPRING.getName());
    }
}

enum Season {
    SPRING("spring", "warm"),
    WINTER("winter", "cold"),
    AUTUMN("autumn", "cool"),
    SUMMER("summer", "hot");

    private String name;
    private String desc;// 描述

    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}