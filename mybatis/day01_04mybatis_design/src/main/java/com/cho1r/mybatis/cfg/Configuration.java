package com.cho1r.mybatis.cfg;

import java.util.HashMap;
import java.util.Map;

/**
 * Author cho1r
 * 2022/01/03 下午 07:37
 * 自定义 mybatis 的配置类
 */
public class Configuration {

    private String driver;
    private String url;
    private String username;
    private String password;

    private Map<String, Mapper> mappers = new HashMap<>();

    public Map<String, Mapper> getMappers() {
        return mappers;
    }

    public void setMappers(Map<String, Mapper> mappers) {
        this.mappers.putAll(mappers);// 采用追加的方式
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
