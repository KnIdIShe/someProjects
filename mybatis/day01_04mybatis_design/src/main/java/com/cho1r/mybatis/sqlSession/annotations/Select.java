package com.cho1r.mybatis.sqlSession.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author cho1r
 * 2022/01/04 下午 01:22
 * 查询的注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Select {
    /**
     * 配置 SQL 语句
     *
     * @return
     */
    String value();
}
