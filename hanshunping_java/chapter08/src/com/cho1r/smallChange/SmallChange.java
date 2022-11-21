package com.cho1r.smallChange;

import java.util.Scanner;

/**
 * Author cho1r
 * 2021/12/13 下午 06:35
 */
public class SmallChange {
    public static void main(String[] args) {

        // 循环结束标志
        boolean flag = true;
        // 输入
        Scanner scanner = new Scanner(System.in);
        int key = 0;
        do {
            // 主界面
            System.out.println("==========零钱通==========");
            System.out.println("          1 明细");
            System.out.println("          2 收益");
            System.out.println("          3 消费");
            System.out.println("          4 退出");

            System.out.println("plz input your choice.");
            key = scanner.nextInt();

            switch (key) {
                case 1 -> {
                    System.out.println("getDetail()");
                }
                case 2 -> {
                    System.out.println("detIncome()");
                }
                case 3 -> {
                    System.out.println("detConsumption()");
                }
                case 4 -> {
                    flag = false;
                }
                default -> System.out.println("wrong input, plz input again.");
            }
//            if (key == 4) {
//                flag = false;
//            }
        } while (flag);
    }
}
