package com.cho1r.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Author cho1r
 * 2022/01/02 下午 05:04
 */
public class User implements Serializable {
    private long id;
    private String name;
    private Date birthday;
    private char sex;
    private String address;

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", birthday=" + birthday +
//                ", sex=" + sex +
//                ", address='" + address + '\'' +
//                '}';
//    }
}
