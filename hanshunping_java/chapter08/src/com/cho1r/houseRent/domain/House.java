package com.cho1r.houseRent.domain;

import com.cho1r.houseRent.service.HouseService;

import java.util.Objects;

/**
 * Author cho1r
 * 2021/12/15 上午 10:28
 */
public class House {
    private int id;
    private String name;
    private String phone;
    private String address;
    private int rent;
    private String state;

    public House(String name, String phone, String address, int rent, String state) {
        this.id = HouseService.getId();
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.rent = rent;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return id +
                "\t\t" + name +
                "\t\t" + phone +
                "\t\t" + address +
                "\t\t" + rent +
                "\t\t" + state
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return id == house.id && rent == house.rent && Objects.equals(name, house.name) && Objects.equals(phone, house.phone) && Objects.equals(address, house.address) && Objects.equals(state, house.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phone, address, rent, state);
    }
}
