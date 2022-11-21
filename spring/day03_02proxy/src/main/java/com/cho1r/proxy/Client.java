package com.cho1r.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Author cho1r
 * 2021/12/26 上午 09:33
 * 消费者
 */
public class Client {
    public static void main(String[] args) {

        final Producer producer = new Producer();
//        producer.saleProduct(5999);

        IProducer proxyProducer = (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(), producer.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
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
        proxyProducer.saleProduct(5999);
    }
}
