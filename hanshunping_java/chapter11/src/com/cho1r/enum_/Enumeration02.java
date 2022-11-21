package com.cho1r.enum_;

/**
 * Author cho1r
 * 2021-11-24 024 03:11 下午
 * 自定义枚举类
 */
public class Enumeration02 {
    public static void main(String[] args) {
        System.out.println(Season.AUTUMN);
        System.out.println(Season.SPRING.getName());
    }
}

//class Season {
//    private String name;
//    private String desc;// 描述
//
//    public final static Season SPRING = new Season("spring", "warm");
//    public final static Season WINTER = new Season("winter", "cold");
//    public final static Season AUTUMN = new Season("autumn", "cool");
//    public final static Season SUMMER = new Season("summer", "hot");
//
//    // 1. 构造器私有化
//    // 2. 取消setXXX方法
//    // 3. 创建固定对象
//    private Season(String name, String desc) {
//        this.name = name;
//        this.desc = desc;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getDesc() {
//        return desc;
//    }
//
//    @Override
//    public String toString() {
//        return "Season{" +
//                "name='" + name + '\'' +
//                ", desc='" + desc + '\'' +
//                '}';
//    }
//}