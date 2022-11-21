package com.cho1r.mybatis.sqlSession;

import com.cho1r.mybatis.cfg.Configuration;
import com.cho1r.mybatis.sqlSession.defaults.DefaultSqlSessionFactory;
import com.cho1r.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * Author cho1r
 * 2022/01/03 下午 07:02
 * 用于创建一个 SqlSessionFactory 对象
 */
public class SqlSessionFactoryBuilder {

    /**
     * 根据参数的字节输入流来构建一个 SqlSessionFactory 工厂
     *
     * @param config
     * @return
     */
    public SqlSessionFactory build(InputStream config) {
        Configuration configuration = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlSessionFactory(configuration);
    }

}
