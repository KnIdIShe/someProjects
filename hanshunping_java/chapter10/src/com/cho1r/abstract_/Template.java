package com.cho1r.abstract_;

/**
 * Author cho1r
 * 2021/12/17 上午 10:41
 * 模板设计模式
 */
public class Template {
    public static void main(String[] args) {
        new A().calRunTime();
    }
}

abstract class TemplateBase {
    public void calRunTime() {
        long start = System.currentTimeMillis();
        job();
        long end = System.currentTimeMillis();

        System.out.println("runtime = " + (end - start));

    }

    public abstract void job();
}

class A extends TemplateBase {

    @Override
    public void job() {
        int sum = 0;
        for (int i = 0; i < 99999; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}