package com.cho1r.static_;

/**
 * Author cho1r
 * 2021/12/16 下午 06:31
 * 单例模式-饿汉式
 */
public class SingleTon_ {
    public static void main(String[] args) {
        System.out.println(GF.getGf() == GF.getGf());
    }

}

class GF {
    private GF() {
    }

    private static GF gf = new GF();

    public static GF getGf() {
        return gf;
    }
}