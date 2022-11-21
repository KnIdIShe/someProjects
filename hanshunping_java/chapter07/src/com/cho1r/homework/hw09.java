package com.cho1r.homework;

/**
 * Author cho1r
 * 2021/12/08 下午 06:07
 */
public class hw09 {
    public static void main(String[] args) {
        Music gburi = new Music("gburi", 3.56);
        gburi.play();
        gburi.info();
    }
}

class Music {
    private String name;
    private double times;

    public Music(String name, double times) {
        this.name = name;
        this.times = times;
    }

    public void play() {
        System.out.println("playing now.");
    }

    public void info() {
        System.out.println("Music{" +
                "name='" + name + '\'' +
                ", times=" + times +
                '}');
    }
}