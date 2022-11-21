package com.cho1r.homework;

/**
 * Author cho1r
 * 2021/12/08 下午 03:31
 */
public class hw03 {
    public static void main(String[] args) {
        Book book = new Book();
        book.changePrice(23);

    }
}

class Book {
    private int price;

    public void changePrice(int price) {
        if (price > 150) {
            this.price = 150;
        } else if (price > 100) {
            this.price = 100;
        }
        System.out.println(this.price);
    }
}