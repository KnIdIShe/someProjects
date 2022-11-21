package com.cho1r.anno;

import org.jetbrains.annotations.NotNull;

import javax.annotation.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Author cho1r
 * 2021/12/30 下午 07:20
 */
@Report(type = 1, level = "warn", value = "tom")
public class Test {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException {
//        boolean annotationPresent = Test.class.isAnnotationPresent(Report.class);
//        System.out.println(annotationPresent);
//
//        Report report = Test.class.getAnnotation(Report.class);
//        System.out.println(report.type());
//        System.out.println(report.level());
//        System.out.println(report.value());

//        Method method = Test.class.getDeclaredMethod("hi", String.class, String.class);
//        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
//        for (Annotation[] parameterAnnotation : parameterAnnotations) {
//            for (Annotation annotation : parameterAnnotation) {
//                if (annotation instanceof NotNull) {
//                    System.out.println("NotNull " + annotation);
//                }
//
//                if (annotation instanceof Range) {
//                    System.out.println("Range " + annotation);
//                }
//            }
//        }

        check(new Person("tom", 80));

    }

    public void hi(@NotNull @Range(min = 1, max = 10) String name, @NotNull String prefix) {
    }

    public static void check(Person person) throws IllegalAccessException {
        // 遍历所有Field:
        for (Field field : person.getClass().getDeclaredFields()) {
            // 获取Field定义的@Range:
            Range range = field.getDeclaredAnnotation(Range.class);
            // 如果@Range存在:
            if (range != null) {
                // 获取Field的值:
                field.setAccessible(true);
                Object value = field.get(person);
                // 如果值是String:
                if (value instanceof String) {
                    String s = (String) value;
                    // 判断值是否满足@Range的min/max:
                    if (s.length() < range.min() || s.length() > range.max()) {
                        throw new IllegalArgumentException("Invalid field: " + field.getName());
                    }
                }

                // 如果值是 int:
                if (value instanceof Integer) {
                    int s = (int) value;
                    // 判断值是否满足@Range的min/max:
                    if (s < range.min() || s > range.max()) {
                        throw new IllegalArgumentException("Invalid field: " + field.getName());
                    }
                }
            }
        }
    }


}

class Person {

    @Range(max = 20)
    private String name;

    @Range(max = 120)
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
