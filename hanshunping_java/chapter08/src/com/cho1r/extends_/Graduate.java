package com.cho1r.extends_;

/**
 * Author cho1r
 * 2021/12/09 下午 07:09
 */
public class Graduate extends Students {
    public Graduate(String name, int age, double score) {
        super(name, age, score);
    }

    public void testing() {
        System.out.println("大学生 " + name + " 正在考大学数学.");
    }
}
