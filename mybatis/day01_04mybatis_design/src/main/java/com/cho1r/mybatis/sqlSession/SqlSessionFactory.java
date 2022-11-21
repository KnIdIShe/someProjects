package com.cho1r.mybatis.sqlSession;

/**
 * Author cho1r
 * 2022/01/03 下午 07:04
 */
public interface SqlSessionFactory {

    /**
     * 用于开启一个新的 SqlSession 对象
     * @return
     */
    SqlSession openSession();
}
