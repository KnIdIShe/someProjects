package com.cho1r;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Author cho1r
 * 2021/12/19 上午 11:12
 */
public class HorseChessboard {
    // col
    private static int x = 6;
    // row
    private static int y = 6;
    // 棋盘
    public static int[][] chessboard = new int[x][y];
    // 记录位置是否走过
    private static boolean[] visited = new boolean[x * y];
    // 是否遍历完整个棋盘
    private static boolean finished = false;


    public static void main(String[] args) {

        int row = 2;
        int col = 2;
        long s = System.currentTimeMillis();
        travelChessboard(chessboard, row - 1, col - 1, 1);
        long e = System.currentTimeMillis();

        System.out.println(e - s);// 80105, 23

        for (int[] ints : chessboard) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }


    }

    // 遍历棋盘
    public static void travelChessboard(int[][] chessboard, int row, int col, int step) {
        // 第一步
        chessboard[row][col] = step;
        // 将当前位置设置为已访问
        visited[row * x + col] = true;
        // 获取当前位置可以走的所有位置
        ArrayList<Point> list = next(new Point(row, col));
        sort(list);

        while (!list.isEmpty()) {
            Point point = list.remove(0);
            // 判断之前是否走过
            if (visited[point.x * x + point.y] == false) {
                // 没走过, 递归
                travelChessboard(chessboard, point.x, point.y, step + 1);
            }
        }

        // 判断是否成功, 失败则重置
        if ((step < x * y) && finished == false) {
            // 则当前位置无法走通, 重置
            chessboard[row][col] = 0;
            // 重置为未走过
            visited[row * x + col] = false;
        } else {
            finished = true;
        }


    }

    // 按当前点的接下来可走的点的个数升序排序
    public static void sort(ArrayList<Point> arrayList) {
        arrayList.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return next(o1).size() - next(o2).size();
            }
        });
    }


    // 获取当前位置可以走的所有位置
    public static ArrayList<Point> next(Point curPoint) {
        ArrayList<Point> points = new ArrayList<>();

        Point point = new Point();
        // 如果可以走, 则放入 points

        // 判断 5 位置
        if ((point.x = curPoint.x - 2) >= 0 && (point.y = curPoint.y - 1) >= 0) {
            points.add(new Point(point));
        }
        // 判断 6 位置
        if ((point.x = curPoint.x - 1) >= 0 && (point.y = curPoint.y - 2) >= 0) {
            points.add(new Point(point));
        }
        // 判断 7 位置
        if ((point.x = curPoint.x + 1) < y && (point.y = curPoint.y - 2) >= 0) {
            points.add(new Point(point));
        }
        // 判断 0 位置
        if ((point.x = curPoint.x + 2) < y && (point.y = curPoint.y - 1) >= 0) {
            points.add(new Point(point));
        }
        // 判断 1 位置
        if ((point.x = curPoint.x + 2) < y && (point.y = curPoint.y + 1) < x) {
            points.add(new Point(point));
        }
        // 判断 2 位置
        if ((point.x = curPoint.x + 1) < y && (point.y = curPoint.y + 2) < x) {
            points.add(new Point(point));
        }
        // 判断 3 位置
        if ((point.x = curPoint.x - 1) >= 0 && (point.y = curPoint.y + 2) < x) {
            points.add(new Point(point));
        }
        // 判断 4 位置
        if ((point.x = curPoint.x - 2) >= 0 && (point.y = curPoint.y + 1) < x) {
            points.add(new Point(point));
        }

        return points;
    }
}
