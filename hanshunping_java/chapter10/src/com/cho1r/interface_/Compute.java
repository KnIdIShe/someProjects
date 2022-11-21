package com.cho1r.interface_;

/**
 * Author cho1r
 * 2021/12/17 上午 11:06
 */
public class Compute {
    public void work(UsbInterface usbInterface) {
        usbInterface.start();
        usbInterface.stop();
    }
}
