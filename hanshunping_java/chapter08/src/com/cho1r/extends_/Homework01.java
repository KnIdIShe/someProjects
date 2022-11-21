package com.cho1r.extends_;

/**
 * Author cho1r
 * 2021/12/10 下午 04:24
 */
public class Homework01 {
    public static void main(String[] args) {
        System.out.println(new PC("i7", "8G", "1T", "shinelon").getDetail());
        System.out.println(new NotePad("i7", "8G", "1T", "shinelon", "black").getDetail());
    }

}

class Computer {
    private String cpu;
    private String memory;
    private String disk;

    public Computer(String cpu, String memory, String disk) {
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
    }

    public String getDetail() {
        return "cpu='" + cpu + '\'' +
                ", memory='" + memory + '\'' +
                ", disk='" + disk + '\'';
    }
}

class PC extends Computer {
    private String brand;

    public PC(String cpu, String memory, String disk, String brand) {
        super(cpu, memory, disk);
        this.brand = brand;
    }

    public String getDetail() {
        return super.getDetail() +
                ", brand='" + brand + '\'';
    }
}

class NotePad extends PC {
    private String color;

    public NotePad(String cpu, String memory, String disk, String brand, String color) {
        super(cpu, memory, disk, brand);
        this.color = color;
    }

    public String getDetail() {
        return super.getDetail() +
                ", color='" + color + '\'';
    }
}