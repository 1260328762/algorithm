package com.cl.question.recursion;

/**
 * @author chenliang
 * @since 2021/12/22 13:59
 * <p>
 * 细胞分裂
 * <p>
 * 一个细胞的生命周期是三个小时，一个小时分裂一次，求n个小时后，容器内有多少细胞，细胞会在每小时的开始先分裂后死亡
 * <p>
 * 解题思路
 * <p>
 * 假设不算死亡的细胞，则细胞每次分裂后容器内的细胞个数是原来细胞个数的二倍
 * <p>
 * 第一个小时，2个细胞
 * 第二个小时，4个细胞
 * 第三个小时，8个细胞
 * <p>
 * 由此可得细胞分裂公式为f(n) = f(n - 1) * 2;
 * <p>
 * 从第四个小时开始，开始有细胞死亡，死亡个数即为前四个小时，容器内的细胞含量即f(n - 4)
 * <p>
 * 总的计算公式为f(n) = f(n - 1) * 2 -f(n - 4);
 */
public class CellDivision {

    public int cellDivision(int n) {
        if (n == 0) return 1;
        if (n == 1) return 2;
        if (n == 2) return 4;
        if (n == 3) return 8;
        return 2 * cellDivision(n - 1) - cellDivision(n - 4);
    }

    public static void main(String[] args) {
        CellDivision cellDivision = new CellDivision();
        int i = cellDivision.cellDivision(5);
        System.out.println(i);
    }
}
