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
     * 再不超过W的情况下，最高可以装多重的重量, 有多少种装法
     */
    public static void loadPack(int maxW, int[] items) {
        recLoad(maxW, 0, items, 0);
    }

    private static boolean[][] men = new boolean[5][10];

    private static void recLoad(int maxW, int cw, int[] items, int i) {
        if (cw >= maxW || i == items.length) {
            System.out.println(cw);
            return;
        }

        if (men[i][cw]) return;
        men[i][cw] = true;

        // 选择不装第i个物品
        recLoad(maxW, cw, items, i + 1);

        // 选择装第i个物品
        if (cw + items[i] <= maxW) {
            recLoad(maxW, cw + items[i], items, i + 1);
        }
    }


    /**
     * 动态规划
     *
     * @param weight
     * @param n
     * @param w
     * @return
     */
    public static int knapsack(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w + 1]; // 默认值false
        states[0][0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
        if (weight[0] <= w) {
            states[0][weight[0]] = true;
        }

        // 动态规划状态转移
        for (int i = 1; i < n; ++i) {

            // 不把第i个物品放入背包
            for (int j = 0; j <= w; ++j) {
                if (states[i - 1][j]) states[i][j] = states[i - 1][j];
            }

            //把第i个物品放入背包
            for (int j = 0; j <= w - weight[i]; ++j) {
                if (states[i - 1][j]) states[i][j + weight[i]] = true;
            }
        }

        // 输出结果
        for (int i = w; i >= 0; --i) {
            if (states[n - 1][i]) return i;
        }

        return 0;
    }


    /**
     * 递归计算阶乘
     *
     * @param num
     */
    public static void factorial(int num) {
        System.out.println(recFactorial(num));
    }


    private static int recFactorial(int num) {
        if (num == 1) return 1;
        return num * recFactorial(num - 1);
    }
}
