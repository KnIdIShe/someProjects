package com.cho1r.proxy;

/**
 * Author cho1r
 * 2021/12/26 上午 09:32
 * 对生产厂家要求的接口
 */
public interface IProducer {

    /**
     * 销售
     * @param money
     */
    public void saleProduct(double money);

    /**
     * 售后
     * @param money
     */
    public void afterService(double money);
}
