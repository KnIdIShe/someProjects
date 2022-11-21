package com.cho1r.mybatis.sqlSession.defaults;

import com.cho1r.mybatis.cfg.Configuration;
import com.cho1r.mybatis.sqlSession.SqlSession;
import com.cho1r.mybatis.sqlSession.SqlSessionFactory;

/**
 * Author cho1r
 * 2022/01/04 上午 09:18
 * SqlSessionFactory 接口的实现类
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg) {
        this.cfg = cfg;

    }

    /**
     * 用于创建一个新的操作数据库对象
     *
     * @return
     */
    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
