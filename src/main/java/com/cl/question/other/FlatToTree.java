package com.cl.question.other;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenliang
 * @since 2022/10/31 21:14
 * 给定一个字符串，将字符串转换成树形结构
 * 如，将“demo/test/get1, demo/test/get2, demo2/test/get1” 转化为下面的树形结构
 *                                   demo
 *                                      test
 *                                          get1
 *                                          get2
 *                                   demo2
 *                                       test
 *                                          get1
 */
public class FlatToTree {

    /**
     * 以Map形式代替树形结构
     * @return
     */
    public Map toTree(String input) {
        Map<String, Object> result = new HashMap<>();
        String[] strings = Arrays.stream(input.split(",")).toArray(String[]::new);
        for (String string : strings) {
            Map<String, Object> next = result;
            String[] split = string.split("/");
            int start = 0;
            for (; start < split.length; start++) {
                Map value = (Map) next.get(split[start]);
                if (value != null) {
                    next = value;
                } else {
                    break;
                }
            }

            for (int i = start; i < split.length; i++) {
                Map<String, Object> value = new HashMap<>();
                next.put(split[i], value);
                next = value;
            }
        }
        return result;
    }
}
