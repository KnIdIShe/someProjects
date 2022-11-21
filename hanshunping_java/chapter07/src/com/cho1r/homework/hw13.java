package com.cho1r.homework;

/**
 * Author cho1r
 * 2021/12/09 上午 09:53
 */
public class hw13 {
    public static void main(String[] args) {
        Circle circle = new Circle();
        new passObject().printAreas(circle, 5);
    }
}

class Circle {
    private double radius;

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}

class passObject {
    public void printAreas(Circle c, int times) {
        System.out.println("radius\tarea");
        for (int i = 1; i <= times; i++) {
            c.setRadius(i);
            System.out.println(i + "\t" + c.getArea());
        }
    }
}