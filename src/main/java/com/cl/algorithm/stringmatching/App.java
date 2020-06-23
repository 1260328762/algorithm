package com.cl.algorithm.stringmatching;

import java.util.Arrays;

/**
 * @author chenliang
 * @date 2020-06-19
 */
public class App {
    public static void main(String[] args) {
        String mainStr = "abcacabdc";

        // int size = 10000000;
        // String[] modeStr = new String[size];
        // Arrays.fill(modeStr, "abd");
        //
        // long l = System.currentTimeMillis();
        // for (String s : modeStr) {
        //     StringMatching.bm(mainStr, s);
        // }
        // System.out.println(System.currentTimeMillis() - l);

        System.out.println(StringMatching.bm(mainStr, "abd"));
    }
}
