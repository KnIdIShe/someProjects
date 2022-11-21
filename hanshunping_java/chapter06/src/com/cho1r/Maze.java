package com.cho1r;

/**
 * Author cho1r
 * 2021/12/06 下午 01:23
 * 小老鼠出迷宫
 */
public class Maze {
    public static void main(String[] args) {
        int[][] maze = new int[8][7];

        // 初始化上下两行地图
        for (int i = 0; i < 7; i++) {
            maze[0][i] = 1;
            maze[7][i] = 1;
        }

        // 初始化左右两列地图
        for (int i = 1; i < 7; i++) {
            maze[i][0] = 1;
            maze[i][6] = 1;
        }

        // 初始化障碍物
        maze[3][1] = 1;
        maze[3][2] = 1;

        findWay(maze, 1, 1);

        // 显示地图
        for (int[] ints : maze) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        /**
         * 1 1 1 1 1 1 1
         * 1 0 0 0 0 0 1
         * 1 0 0 0 0 0 1
         * 1 1 1 0 0 0 1
         * 1 0 0 0 0 0 1
         * 1 0 0 0 0 0 1
         * 1 0 0 0 0 0 1
         * 1 1 1 1 1 1 1
         */
    }

    public static boolean findWay(int[][] maze, int i, int j) {
        // 是否已到终点
        if (maze[6][5] == 2) {
            return true;
        }
        // 是否已到边界(1)或障碍物(1)或已走过的路(2)或死胡同(3)
        if (maze[i][j] != 0) {
            return false;
        }
        // 假定从当前位置出发可找到出口
        maze[i][j] = 2;
        // 顺时针方向寻路
        if (findWay(maze, i, j + 1)) {// 右
            return true;
        } else if (findWay(maze, i + 1, j)) {// 下
            return true;
        } else if (findWay(maze, i, j - 1)) {// 左
            return true;
        } else if (findWay(maze, i - 1, j)) {// 上
            return true;
        } else {
            // 将当前位置出发设置为无法找到出口
            maze[i][j] = 3;
            return false;
        }
    }


//    public static boolean findWay(int[][] maze, int i, int j) {
//        // 是否已到终点
//        if (maze[6][5] == 2) {
//            return true;
//        }
//        // 是否已到边界(1)或障碍物(1)或已走过的路(2)或死胡同(3)
//        if (maze[i][j] != 0) {
//            return false;
//        }
//        // 假定从当前位置出发可找到出口
//        maze[i][j] = 2;
//        // 逆时针方向寻路
//        if (findWay(maze, i + 1, j)) {// 下
//            return true;
//        } else if (findWay(maze, i, j + 1)) {// 右
//            return true;
//        } else if (findWay(maze, i - 1, j)) {// 上
//            return true;
//        } else if (findWay(maze, i, j - 1)) {// 左
//            return true;
//        } else {
//            // 将当前位置出发设置为无法找到出口
//            maze[i][j] = 3;
//            return false;
//        }
//    }
}
