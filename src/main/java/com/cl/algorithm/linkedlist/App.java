package com.cl.algorithm.linkedlist;

import com.cl.algorithm.util.JsonUtils;

import java.util.HashMap;

/**
 * @author chenliang
 * @date 2020-05-14
 */
public class App {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("sdf", "sdf");

        System.out.println(JsonUtils.toJson(hashMap));
    }
}
