package com.cho1r.domain;

import java.io.Serializable;

/**
 * Author cho1r
 * 2021/12/21 下午 05:38
 * 账户的实体类
 */
public class Account implements Serializable {

    private Integer id;
    private String name;
    private double money;

    public Account() {
    }

    public Account(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
