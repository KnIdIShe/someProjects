package com.cho1r.enum_;

/**
 * Author cho1r
 * 2021-11-25 025 09:38 上午
 */
public class EnumDetail {
    public static void main(String[] args) {
        Music.CLASSIC.play();
    }
}

interface IPlay {
    public void play();
}

// enum 可实现接口, 但不能再继承其他类, 因为底层隐式的继承了 Enum类
enum Music implements IPlay {
    CLASSIC;

    @Override
    public void play() {
        System.out.println("play music.");
    }
}