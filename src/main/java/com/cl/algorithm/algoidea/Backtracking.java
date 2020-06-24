package com.cl.algorithm.algoidea;

/**
 * @author chenliang
 * @date 2020-06-24
 * 回溯算法
 */
public class Backtracking {

    /**
     * 棋盘，下标表示第一行，下标对应的值表示列
     */
    private static int[] result = new int[8];

    /**
     * 八皇后问题
     */
    public static void queensEight() {
        rec(0);
    }

    private static void rec(int row) {
        if (row == 8) {
            printQueens(result);
            return;
        }
        // 一共有八列，从第一列开始循环放置棋子
        for (int i = 0; i < 8; i++) {
            if (isOk(row, i)) {
                result[row] = i;
                rec(row + 1);
            }
        }
    }

    private static boolean isOk(int row, int column) {
        int left = column - 1;
        int right = column + 1;
        for (int i = row - 1; i >= 0; i--) {
            if (result[i] == column) return false;
            if (left >= 0 && result[i] == left) return false;
            if (right < 8 && result[i] == right) return false;
            left--;
            right++;
        }
        return true;
    }

    private static void printQueens(int[] result) {
        for (int row = 0; row < 8; ++row) {
            for (int column = 0; column < 8; ++column) {
                if (result[row] == column) System.out.print("Q ");
                else System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }


    /**
     * 0-1背包
     * 一个背包承重Wkg，一共有n个物品，每个物品重量不等，
     * 再不超过W的情况下，最高可以装多重的重量
     */
    public static void loadPack(int maxW, int[] items){
        recLoad(maxW, 0, items, 0);
    }

    private static void recLoad(int maxW, int cw, int[] items, int i){
        if (maxW <= cw || i == items.length) {
            int result = cw;
            if (maxW < cw) {
                result = cw - items[i - 1];
            }
            System.out.println(result);
            return;
        }
        int nextW = cw + items[i];
        if (nextW > maxW) {
            recLoad(maxW, cw, items, i + 1);
        } else {
            recLoad(maxW, nextW, items, i + 1);
        }
    }

}
