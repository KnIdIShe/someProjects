package com.cho1r.homework;

/**
 * Author cho1r
 * 2021-11-30 030 01:22 下午
 */
public class Homework04 {
    public static void main(String[] args) {
        count("KkclscKJS132");
    }

    //    public static void count(String str) {
//        char[] array = str.toCharArray();
//        int uCC = 0, lCC = 0, nC = 0;
//        int len = array.length;
//        for (int i = 0; i < len; i++) {
//            if (array[i] >= 'A' && array[i] <= 'Z') {
//                uCC++;
//                continue;
//            }
//            if (array[i] >= 'a' && array[i] <= 'z') {
//                lCC++;
//                continue;
//            }
//            if (array[i] >= '0' && array[i] <= '9') {
//                nC++;
//                continue;
//            }
//        }
//        System.out.println("upperCase " + uCC + " lowerCase " + lCC + " num " + nC);
//    }
    public static void count(String str) {
        int uCC = 0, lCC = 0, nC = 0;
        int len = str.length();
        char c;
        for (int i = 0; i < len; i++) {
            c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                uCC++;
                continue;
            }
            if (c >= 'a' && c <= 'z') {
                lCC++;
                continue;
            }
            if (c >= '0' && c <= '9') {
                nC++;
            }
        }
        System.out.println("upperCase " + uCC + " lowerCase " + lCC + " num " + nC);
    }
}
