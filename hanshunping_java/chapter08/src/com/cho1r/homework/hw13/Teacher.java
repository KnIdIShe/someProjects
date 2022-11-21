package com.cho1r.homework.hw13;

/**
 * Author cho1r
 * 2021/12/14 下午 06:43
 */
public class Teacher extends Person {
    private int workAge;

    public Teacher(String name, char sex, int age, int workAge) {
        super(name, sex, age);
        this.workAge = workAge;
    }

    public void teach() {
        System.out.println("hard teaching.");
    }

    @Override
    public String play() {
        return super.play() + "chess.";
    }

    public void printInfo() {
        System.out.println("teacher info:\n" + super.basicInfo());
        System.out.println("workAge: " + workAge);
        teach();
        System.out.println(play());
    }

    @Override
    public String toString() {
        return "Teacher{" + super.toString() +
                ", workAge=" + workAge +
                '}';
    }
}
