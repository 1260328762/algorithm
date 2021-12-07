package com.cl.question;

/**
 * @author chenliang
 * @since 2021/12/5 19:00
 *
 * TODO 进阶；1，减少时间复杂度，用两个boolean数组存储要置零的行和列
 */
public class SetZeroes {

    public void setZeroes(int[][] matrix) {
        int[][] indexs = new int[matrix.length][];
        int size = 0;

        for (int i = 0; i < matrix.length; i++) {
            int[] inner = matrix[i];

            for (int j = 0; j < inner.length; j++) {
                if (inner[j] == 0) {
                    indexs[size++] = new int[]{i, j};
                }
            }
        }

        for (int i = 0; i < size; i++) {
            int[] index = indexs[i];

            // 列清零
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][index[1]] = 0;
            }

            // 行清零
            int[] line = matrix[index[0]];
            for (int k = 0; k < line.length; k++) {
                matrix[index[0]][k] = 0;
            }
        }
    }


    public static void main(String[] args) {
        // int[][] input = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        // new SetZeroes().setZeroes(input);
        //
        // for (int[] ints : input) {
        //     System.out.println(Arrays.toString(ints));
        // }

        int[][] ints = new int[2][];

        for (int[] anInt : ints) {
            System.out.println(anInt.length);
        }
    }
}
