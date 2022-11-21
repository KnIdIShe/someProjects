package com.cho1r.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Author cho1r
 * 2021/12/26 上午 09:33
 * 消费者
 */
public class Client {
    public static void main(String[] args) {

        Producer producer = new Producer();
//        producer.saleProduct(5999);

        Producer cglibProducer = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                // 提供增强的代码

                Object retVal = null;
                // 获取方法执行的参数
                double money = (double) args[0];
                // 判断当前方法是不是销售
                if ("saleProduct".equals(method.getName())) {
                    retVal = method.invoke(producer, money * 0.8);
                }
                return retVal;
            }
        });

        cglibProducer.saleProduct(5999);


    }
}
