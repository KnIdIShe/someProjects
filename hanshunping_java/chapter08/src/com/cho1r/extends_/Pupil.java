package com.cho1r.extends_;

/**
 * Author cho1r
 * 2021/12/09 下午 07:06
 */
public class Pupil extends Students {
    public Pupil(String name, int age, double score) {
        super(name, age, score);
    }

    public void testing() {
        System.out.println("小学生 " + name + " 正在考小学数学.");
    }
}
