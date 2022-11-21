package com.cho1r.stringBuffer;

/**
 * Author cho1r
 * 2021-11-28 028 07:13 下午
 */
public class String2StringBuffer {
    public static void main(String[] args) {
        // string --> stringBuffer
        String tom = "tom";
        // type 1
        StringBuffer stringBuffer1 = new StringBuffer(tom);
        // type 2
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(tom);

        // stringBuffer --> string
        // type1
        String s = stringBuffer.toString();
        // type2
        String s1 = new String(stringBuffer);

        stringBuffer.append(100).append(true);


    }
}
