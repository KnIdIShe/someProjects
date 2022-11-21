package com.cho1r.mybatis.io;

import java.io.InputStream;

/**
 * Author cho1r
 * 2022/01/03 下午 06:57
 * 使用类加载器读取配置文件的类
 */
public class Resources {

    public static InputStream getResourceAsStream(String filePath) {
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
