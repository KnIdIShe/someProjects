package com.cho1r.homework;

import java.util.regex.Pattern;

/**
 * Author cho1r
 * 2021-11-30 030 11:14 上午
 */
public class Homework02 {
    public static void main(String[] args) {
        String name = "tom";
        String password = "123456";
        String email = "tom@gmail.com";

//        String pName = "\\S{2,4}";
//        String pPwd = "\\d{6}";
//        String pMail = "\\w+@\\w+\\.\\w+";
//
//        if (!Pattern.matches(pName, name)) {
//            throw new IllegalArgumentException("wrong name.");
//        }
//        if (!Pattern.matches(pPwd, password)) {
//            throw new IllegalArgumentException("wrong password.");
//        }
//        if (!Pattern.matches(pMail, email)) {
//            throw new IllegalArgumentException("wrong email.");
//        }

        if (!(name.length() >= 2 && name.length() <= 4)) {
            throw new IllegalArgumentException("wrong name.");
        }

        if (password.length() > 6) {
            throw new IllegalArgumentException("wrong password.");
        }
        char[] arrPwd = password.toCharArray();
        for (int i = 0; i < arrPwd.length; i++) {
//            if (!Character.isDigit(arrPwd[i])) {
//                throw new IllegalArgumentException("wrong password.");
//            }
            if (arrPwd[i] < '0' || arrPwd[i] > '9') {
                throw new IllegalArgumentException("wrong password.");
            }
        }

        char[] arrEmail = email.toCharArray();
        if (!(email.indexOf('.') != -1 && email.indexOf('@') != -1 && email.indexOf('.') > email.indexOf('@') + 1)) {
            throw new IllegalArgumentException("wrong email.");
        }


        System.out.println(name + "\t" + password + "\t" + email);
    }
}
