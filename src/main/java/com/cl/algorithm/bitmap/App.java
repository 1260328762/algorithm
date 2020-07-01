package com.cl.algorithm.bitmap;

import java.nio.charset.Charset;
import java.util.BitSet;

/**
 * @author chenliang
 * @date 2020-06-30
 */
public class App {
    public static void main(String[] args) {

        BitMap bitMap = new BitMap(10);

        bitMap.set(2);
        bitMap.set(9);

        System.out.println("\u0004");

        System.out.println(bitMap.get(2));

        System.out.println(9 << 16);

        // BitSet bitSet = new BitSet();
        // bitSet.set(1);
    }
}
