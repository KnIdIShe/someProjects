package com.cho1r.generic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author cho1r
 * 2021-11-17 017 07:13 下午
 */
public class Homework01 {
    public static void main(String[] args) {


    }

    @Test
    public void testDao() {
        DAO<User> dao = new DAO<>();
        dao.save("1", new User(1, "tom", 12));

        dao.update("1", new User(1, "jerry", 10));

        System.out.println(dao.get("1"));

        dao.delete("1");
        System.out.println(dao.list());
    }
}

class DAO<T>  {
    private Map<String, T> map = new HashMap<>();

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        map.replace(id, entity);
    }

    public List<T> list() {
        ArrayList<T> list = new ArrayList<>();
//        for (T v : map.values()) {
//            list.add(v);
//        }
//        return list;

        list.addAll(map.values());
        return list;
    }

    public void delete(String id) {
        map.remove(id);
    }
}

class User {
    private int id;
    private String name;
    private int age;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}