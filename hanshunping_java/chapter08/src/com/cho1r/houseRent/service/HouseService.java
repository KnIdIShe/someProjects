package com.cho1r.houseRent.service;

import com.cho1r.houseRent.domain.House;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Author cho1r
 * 2021/12/15 下午 12:38
 */
public class HouseService {
    private static HashMap<Integer, House> houses = new HashMap<>();

    static {
        houses.put(getId(), new House("tom", "180", "washington", 2300, "未出租"));

    }

    public static int getSize() {
        return houses.size();
    }

    public static int getId() {
        return houses.size() + 1;
    }

    public static void addHouse(House house) {
        houses.put(getId(), house);
    }

    public static void delHouse(int id) {
        houses.remove(id);
    }

    public static House findHouse(int id) {
        return houses.get(id);
    }

    public static Collection<House> list() {
        return houses.values();
    }
}
