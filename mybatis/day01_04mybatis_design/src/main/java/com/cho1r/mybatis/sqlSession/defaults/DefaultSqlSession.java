package com.cho1r.mybatis.sqlSession.defaults;

import com.cho1r.mybatis.cfg.Configuration;
import com.cho1r.mybatis.sqlSession.SqlSession;
import com.cho1r.mybatis.sqlSession.proxy.MapperProxy;
import com.cho1r.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Author cho1r
 * 2022/01/04 上午 09:23
 * SqlSession 接口的实现类
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration cfg;
    private Connection conn;

    public DefaultSqlSession(Configuration cfg) {
        this.cfg = cfg;
        this.conn = DataSourceUtil.getConnection(cfg);
    }

    /**
     * 创建代理对象
     *
     * @param daoInterfaceClass dao 的接口字节码
     * @param <T>
     * @return
     */
    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(), new Class[]{daoInterfaceClass}, new MapperProxy(cfg.getMappers(), conn));
    }

    /**
     * 释放资源
     */
    @Override
    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
