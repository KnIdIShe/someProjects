package com.cho1r.cglib;

/**
 * Author cho1r
 * 2021/12/26 上午 09:23
 * 生产者
 */
public class Producer {

    /**
     * 销售
     * @param money
     */
    public void saleProduct(double money) {
        System.out.println("销售产品, 获得money " + money);
    }

    /**
     * 售后
     * @param money
     */
    public void afterService(double money) {
        System.out.println("提供售后, 获得money " + money);
    }
}
