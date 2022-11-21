package com.cho1r.interface_;

/**
 * Author cho1r
 * 2021/12/17 上午 10:58
 */
public class Interface_ {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Camera camera = new Camera();

        Compute compute = new Compute();

        compute.work(phone);
        compute.work(camera);
    }
}

