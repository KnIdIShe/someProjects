package com.cho1r.interface_;

/**
 * Author cho1r
 * 2021/12/17 上午 11:00
 */
public class Phone implements UsbInterface {

    @Override
    public void start() {
        System.out.println("phone connected.");
    }

    @Override
    public void stop() {
        System.out.println("phone disconnected.");
    }
}
