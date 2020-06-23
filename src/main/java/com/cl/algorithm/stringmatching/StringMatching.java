package com.cl.algorithm.stringmatching;

/**
 * @author chenliang
 * @date 2020-06-19
 * 字符串匹配算法
 */
public class StringMatching {

    /**
     * 采用BF算法进行字符串匹配
     * BF Brute Force 缩写，中文是暴力匹配算法
     *
     * @param main       主串
     * @param patternStr 模式串
     * @return
     */
    public static boolean bf(String main, String patternStr) {
        if (main == null || patternStr == null) return false;
        if (main.length() < patternStr.length()) return false;

        char[] sources = main.toCharArray();
        char[] target = patternStr.toCharArray();

        for (int i = 0; i < sources.length; i++) {
            // 每次要截取的字符串长度
            int end = i + target.length - 1;
            if (end >= sources.length) return false;
            int start = i;

            for (char c : target) {
                if (sources[start] != c) break;
                start++;
            }

            if (start - 1 == end) {
                return true;
            }
        }
        return false;
    }

    /**
     * rk算法
     *
     * @param a
     * @param b
     * @return
     */
    public static int rK(String a, String b) {
        int m = a.length(), n = b.length(), s, j;
        int[] hash = new int[m - n + 1];
        int[] table = new int[26];
        char[] a1 = a.toCharArray();
        char[] b1 = b.toCharArray();
        s = 1;
        //将26的次方存储在一个表里，取的时候直接用,虽然溢出，但没啥问题
        for (j = 0; j < 26; j++) {
            table[j] = s;
            s *= 26;
        }
        for (int i = 0; i <= m - n; i++) {
            s = 0;
            for (j = 0; j < n; j++) {
                s += (a1[i + j] - 'a') * table[n - 1 - j];
            }
            hash[i] = s;
        }
        s = 0;
        for (j = 0; j < n; j++) {
            s += (b1[j] - 'a') * table[n - 1 - j];
        }
        for (j = 0; j < m - n + 1; j++) {
            if (hash[j] == s) {
                return j;
            }
        }
        return -1;
    }


    private static final int SIZE = 256;


    /**
     * bm字符串匹配算法
     *
     * @param main    主串
     * @param modeStr 模式串
     * @return
     */
    public static int bm(String main, String modeStr) {
        char[] mainChars = main.toCharArray();
        char[] modeChars = modeStr.toCharArray();
        int[] bc = new int[SIZE];
        generateBC(modeChars, bc);

        int i = 0;
        while (i <= mainChars.length - 1) {
            int j = modeChars.length - 1;
            for (; j >= 0; j--) {
                if (mainChars[i + j] != modeChars[j]) break;
            }
            if (j < 0) return i;
            i = i + (j - bc[mainChars[i + j]]);
        }
        return -1;
    }

    private static void generateBC(char[] chars, int[] bc) {
        for (int i = 0; i < SIZE; i++) {
            bc[i] = -1;
        }

        for (int i = 0; i < chars.length; i++) {
            int ascii = chars[i];
            bc[ascii] = i;
        }
    }
}
