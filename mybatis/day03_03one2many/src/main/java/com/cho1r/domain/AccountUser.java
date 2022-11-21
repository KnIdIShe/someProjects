package com.cho1r.domain;

/**
 * Author cho1r
 * 2022/01/07 下午 06:42
 */
public class AccountUser extends Account {
    private String name;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString() + " AccountUser{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
