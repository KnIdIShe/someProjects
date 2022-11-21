package com.cho1r.exception_;

import org.junit.jupiter.api.Test;

import java.io.Console;
import java.util.Scanner;

/**
 * Author cho1r
 * 2021-11-26 026 03:20 下午
 */
public class homework01 {
    public static void main(String[] args) {
//        int i = 0;
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            try {
//                i = Integer.parseInt(scanner.next());
//                break;
//            } catch (NumberFormatException e) {
//
//            }
//        }
//        System.out.println(i);

//        test();

        Console cons = System.console();
        String username = cons.readLine("User name: ");
        char[] passwd = cons.readPassword("Password: ");

        System.out.println(username);
        System.out.println(passwd);
    }

    public static void test() {
        int i = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (scanner.hasNextInt()) {
                i = scanner.nextInt();
                break;
            }
            scanner.nextLine();
        }
        System.out.println(i);
    }
}
