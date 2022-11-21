package com.cho1r.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Author cho1r
 * 2022/01/02 下午 05:04
 */
public class User implements Serializable {
    private long id;
    private String name;
    private double money;
    private Date birthday;

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", birthday=" + birthday +
                '}';
    }
}
