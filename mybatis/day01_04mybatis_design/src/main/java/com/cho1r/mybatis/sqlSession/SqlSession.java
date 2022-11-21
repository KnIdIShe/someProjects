package com.cho1r.mybatis.sqlSession;

/**
 * Author cho1r
 * 2022/01/03 下午 07:06
 * 自定义 mybatis 中和数据库交互的核心类
 * 它可以创建 dao 接口的代理对象
 */
public interface SqlSession {

    /**
     * 根据参数创建一个代理对象
     *
     * @param daoInterfaceClass dao 的接口字节码
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoInterfaceClass);

    /**
     * 释放资源
     */
    void close();
}
