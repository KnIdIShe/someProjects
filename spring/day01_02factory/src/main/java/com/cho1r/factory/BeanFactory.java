package com.cho1r.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Author cho1r
 * 2021/12/19 下午 06:52
 * 创建Bean对象的工厂
 * Bean: 计算机英语: 可重用组件
 */
public class BeanFactory {
    private static Properties props;
    // 容器, 存放创建的对象
    private static Map<String, Object> beans;

    static {
        // 实例化对象
        props = new Properties();
        // 获取Properties流对象
        InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            props.load(in);
        } catch (IOException e) {
            throw new ExceptionInInitializerError("初始化properties失败.");
        }
        // 初始化容器
        beans = new HashMap<>(props.size());
//        // 初始化所有对象至容器, 饿汉式
//        Enumeration<Object> keys = props.keys();
//        Object obj = null;
//        while (keys.hasMoreElements()) {
//            String beanName = (String) keys.nextElement();
//            String beanPath = props.getProperty(beanName);
//            try {
//                obj = Class.forName(beanPath).getDeclaredConstructor().newInstance();
//                beans.put(beanName, obj);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
    }

    /**
     * 根据bean的名字获取对应的对象
     *
     * @param beanName
     * @return
     */
//    public static Object getBean(String beanName) {
//        return beans.get(beanName);
//    }
    public static Object getBean(String beanName) {
        String beanPath = props.getProperty(beanName);

        if (beans.get(beanName) == null) {// 懒汉式
            try {
                beans.put(beanName, Class.forName(beanPath).getDeclaredConstructor().newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return beans.get(beanName);
    }
}
