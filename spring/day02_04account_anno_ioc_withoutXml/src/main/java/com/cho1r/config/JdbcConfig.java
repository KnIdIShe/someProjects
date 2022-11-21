package com.cho1r.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Author cho1r
 * 2021/12/24 下午 01:20
 */
@Configuration
public class JdbcConfig {
    //    @Bean(name = "queryRunner")
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public QueryRunner createQueryRunner(DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

    //    @Bean(name = "dataSource")
    @Bean
    public DataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        /**
         *         <property name="driverClass" value="com.mysql.cj.jdbc.Driver"/>
         *         <property name="jdbcUrl" value="jdbc:mysql://localhost:3306/test"/>
         *         <property name="user" value="root"/>
         *         <property name="password" value="root"/>
         */
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUser("root");
        dataSource.setPassword("root");

        return dataSource;
    }
}
