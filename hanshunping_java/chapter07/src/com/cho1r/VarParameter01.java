package com.cho1r;

/**
 * Author cho1r
 * 2021/12/07 上午 09:08
 */
public class VarParameter01 {
    public static void main(String[] args) {
        Tool t = new Tool();
//        System.out.println(t.sum(1, 2, 3));
//        int[] ints = {1, 3, 5};
//        System.out.println(t.sum(ints));

        t.showScore("tom", 78, 89, 60);
    }
}

class Tool {

    public void showScore(String name, int... score) {
        System.out.print(name + " :");
        int length = score.length;
        for (int i = 0; i < length; i++) {
            System.out.print(" " + score[i]);
        }
    }

    public int sum(int... ints) {
        int length = ints.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += ints[i];
        }

        return sum;
    }
}