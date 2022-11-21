package com.cho1r.enum_.homework;

/**
 * Author cho1r
 * 2021-11-25 025 03:36 下午
 */
public class homework06 {
    public static void main(String[] args) {
//        new Person("tom", null).common();
        Person person = new Person("唐僧", VehicleFac.getHorse());
        person.common();
//        new Person("唐僧", VehicleFac.getBoat()).common();
//        new Person("唐僧", VehicleFac.getHorse()).passRiver();
        person.passRiver();
        person.fly();
        person.common();
    }
}

interface Vehicles {
    void work();
}

class Horse implements Vehicles {

    @Override
    public void work() {
        System.out.println("驾驾.");
    }
}

class Boat implements Vehicles {

    @Override
    public void work() {
        System.out.println("划啊划.");
    }
}

class Plane implements Vehicles {

    @Override
    public void work() {
        System.out.println("fly fly.");
    }
}

class VehicleFac {
    private static Horse horse = new Horse();

    private VehicleFac() {
    }

    public static Boat getBoat() {
        return new Boat();
    }

    public static Horse getHorse() {
        return horse;
    }

    public static Plane getPlane() {
        return new Plane();
    }
}

class Person {
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public void passRiver() {
//        if (vehicles == null) {
//            vehicles = VehicleFac.getBoat();
//        }
//        if (vehicles.getClass() != Boat.class) {

        if (!(vehicles instanceof Boat)) {// null, 非Boat及Boat子类 则为 false
//            throw new RuntimeException(vehicles.getClass().getSimpleName() + " 不能过河.");
            vehicles = VehicleFac.getBoat();
        }
        vehicles.work();
    }

    public void common() {
//        if (vehicles == null) {
//            vehicles = VehicleFac.getHorse();
//        }
//        if (vehicles.getClass() != Horse.class) {
        if (!(vehicles instanceof Horse)) {
//            throw new RuntimeException(vehicles.getClass().getSimpleName() + " 不能代步.");
            vehicles = VehicleFac.getHorse();
        }
        vehicles.work();
    }

    public void fly() {
        if (!(vehicles instanceof Plane)) {
            vehicles = VehicleFac.getPlane();
        }
        vehicles.work();
    }
}