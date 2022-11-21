package com.cho1r.mybatis.sqlSession.proxy;

import com.cho1r.mybatis.cfg.Mapper;
import com.cho1r.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

/**
 * Author cho1r
 * 2022/01/04 上午 09:28
 */
public class MapperProxy implements InvocationHandler {

    private Map<String, Mapper> mappers;
    private Connection conn;

    public MapperProxy(Map<String, Mapper> mappers, Connection conn) {
        this.mappers = mappers;
        this.conn = conn;
    }

    /**
     * 对方法进行增强, 即调用 selectList 方法
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 获取方法名
        String methodName = method.getName();
        // 获取方法所在类的名称
        String className = method.getDeclaringClass().getName();
        // 组合 key
        String key = className + "." + methodName;
        // 获取对应的 mapper 对象
        Mapper mapper = mappers.get(key);
        // 判断 mapper 是否为空
        if (mapper == null) {
            throw new IllegalArgumentException("传入的参数有误.");
        }
        // 调用工具类查询所有
        return new Executor().selectList(mapper, conn);


    }
}
