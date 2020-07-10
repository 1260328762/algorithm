package com.cl.algorithm.combat;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author chenliang
 * @date 2020-07-09
 */
public class ShortUrlTest {

    public static void test(){
        int size = 1000000;
        String[] urls = new String[size];

        for (int i = 0; i < size; i++) {
            urls[i] = "https://time.geekbang.org/column/article/80850" + UUID.randomUUID().toString();
        }
        System.out.println("数据填充完成");
        Map<String, Integer> map = new HashMap<>(size);

        long l = System.currentTimeMillis();
        for (String s : urls) {
            String shortUrl = ShortUrlGenerate.generate(s);

            // map.put(shortUrl, map.get(s) == null ? 0 : map.get(s) + 1);
        }
        System.out.println(System.currentTimeMillis() - l);

        List<Integer> collect = map.values()
                .stream()
                .sorted(Comparator.comparingInt(o -> (int) o).reversed())
                .collect(Collectors.toList());
        // System.out.println(collect.get(0));

    }

    public static void main(String[] args) {
        test();
    }

}
