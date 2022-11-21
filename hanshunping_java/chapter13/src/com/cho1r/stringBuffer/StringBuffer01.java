package com.cho1r.stringBuffer;

/**
 * Author cho1r
 * 2021-11-29 029 09:01 上午
 */
public class StringBuffer01 {
    public static void main(String[] args) {
        String s = null;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(s);
        System.out.println(stringBuffer.length());
        System.out.println(stringBuffer);

//        System.out.println(new StringBuffer(s));// public StringBuffer(@NotNull String str)
        // int length = str.length();
        // java.lang.NullPointerException: Cannot invoke "String.length()" because "str" is null

    }
}
