package com.cho1r.test;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Author cho1r
 * 2021/12/24 下午 01:07
 */
public class QueryRunnerTest {
    @Test
    public void testQueryRunner() {
        // 获取容器
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.cho1r");
        // 获取业务层对象
        QueryRunner queryRunner = applicationContext.getBean(QueryRunner.class);
        QueryRunner queryRunner2 = applicationContext.getBean(QueryRunner.class);

        System.out.println(queryRunner == queryRunner2);
    }


}
