package com.yakumo.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Author cho1r
 * 2022/01/10 下午 06:57
 * 账户
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
