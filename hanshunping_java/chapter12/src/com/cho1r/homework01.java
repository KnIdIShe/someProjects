package com.cho1r;

import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

/**
 * Author cho1r
 * 2021-11-26 026 06:11 下午
 */
public class homework01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = 0, j = 0;
        while (true) {
            try {
                System.out.println("plz input 2 nums.");
                i = scanner.nextInt();
                j = scanner.nextInt();
                if (j == 0) {
                    throw new ArithmeticException("除数不能为0.");
                }
                if (Integer.valueOf(i) != null && Integer.valueOf(j) != null) {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e);
                scanner.nextLine();
            }
        }
        System.out.println(cal(i, j));
    }

    public static double cal(int i, int j) {
        return (double) i / j;
    }
}
