package com.cl.algorithm.sort;

/**
 * @author chenliang
 * @date 2020-05-28
 * 字母排序，小写字母放前面，大写字母放后面，字母内部不需要排序
 */
public class LetterSort {

    public static void partitionSort(char[] letters) {
        int start = 0;

        for (int i = 0; i < letters.length; i++) {
            char letter = letters[i];
            if (Character.isLowerCase(letter)) {
                char temp = letters[start];
                letters[start++] = letter;
                letters[i] = temp;
            }
        }

        for (int i = start; i < letters.length; i++) {
            char letter = letters[i];
            if (Character.isDigit(letter)) {
                char temp = letters[start];
                letters[start++] = letter;
                letters[i] = temp;
            }
        }
    }
}
