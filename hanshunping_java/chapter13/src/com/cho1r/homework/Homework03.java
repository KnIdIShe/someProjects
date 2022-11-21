package com.cho1r.homework;

/**
 * Author cho1r
 * 2021-11-30 030 12:51 下午
 */
public class Homework03 {
    public static void main(String[] args) {
        System.out.println(formatName("Willian Jefferson Clinton"));
    }

//    public static String formatName(String name) {
//        String[] s = name.split(" ");
//        StringBuilder sb = new StringBuilder();
//        sb.append(s[s.length-1]);
//        sb.append(", ");
//        sb.append(s[0]);
//        sb.append(" .");
//        sb.append(Character.toUpperCase(s[1].charAt(0)));
//        return sb.toString();// Clinton, Willian .J
//    }

    public static String formatName(String name) {
        String[] s = name.split(" ");
//        return String.format("%s, %s .%s", s[s.length - 1], s[0], Character.toUpperCase(s[1].charAt(0)));
        return String.format("%s, %s .%s", s[s.length - 1], s[0], s[1].toUpperCase().charAt(0));
        // Clinton, Willian .J
    }
}
