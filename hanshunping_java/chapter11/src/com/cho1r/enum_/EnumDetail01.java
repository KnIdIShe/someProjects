package com.cho1r.enum_;

/**
 * Author cho1r
 * 2021-11-24 024 06:15 下午
 */
public class EnumDetail01 {
    public static void main(String[] args) {
        Gender boy = Gender.BOY;
        Gender boy1 = Gender.BOY;
        System.out.println(boy);
        System.out.println(boy == boy1);
    }
}

enum Gender {
    BOY, GIRL;
}