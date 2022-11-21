package com.cho1r.arrays_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Author cho1r
 * 2021-11-29 029 04:04 下午
 */
public class ArraysExercise {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦", 12);
        books[1] = new Book("三国演义", 23);
        books[2] = new Book("三国演义新版", 22);
        books[3] = new Book("西游记后传", 5);

        // 价格 正序
//        Arrays.sort(books, new Comparator<Book>() {
//            @Override
//            public int compare(Book o1, Book o2) {
//                return o1.getPrice() - o2.getPrice();
//            }
//        });
        // 价格 逆序
//        Arrays.sort(books, new Comparator<Book>() {
//            @Override
//            public int compare(Book o1, Book o2) {
//                return o2.getPrice() - o1.getPrice();
//            }
//        });

        // 书名长度 逆序
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o2.getName().length() - o1.getName().length();
            }
        });

        System.out.println(Arrays.toString(books));

    }
}

class Book {
    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}