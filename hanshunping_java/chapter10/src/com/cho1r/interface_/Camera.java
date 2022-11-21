package com.cho1r.interface_;

/**
 * Author cho1r
 * 2021/12/17 上午 11:04
 */
public class Camera implements UsbInterface {
    @Override
    public void start() {
        System.out.println("camera connected.");
    }

    @Override
    public void stop() {
        System.out.println("camera disconnected.");
    }
}
