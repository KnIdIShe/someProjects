package com.cho1r.domain;

import java.io.Serializable;

/**
 * Author cho1r
 * 2021/12/27 下午 02:54
 * 账户的实体类
 */
public class Account implements Serializable {

    private long id;
    private String name;
    private double money;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
