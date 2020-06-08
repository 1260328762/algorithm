package com.cl.algorithm.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Objects;

/**
 * @author chenliang
 * @date 2020-5-25
 */
public class JsonUtils {
    public static String toJson(Object data) {
        return JSONObject.toJSONString(data);
    }

    public static <T> T toBean(String json, Class<T> t) {
        return JSONObject.parseObject(json, t);
    }

    public static <T> List<T> toList(String json, Class<T> t) {
        return JSONObject.parseArray(json, t);
    }

    public static <T> List<T> toList(Object object, Class<T> t) {
        return JSONObject.parseArray(JSON.toJSONString(object), t);
    }

    public static <T> T toBean(Object source, Class<T> t) {
        Objects.requireNonNull(source, "source can not be null");
        return JSONObject.parseObject(source instanceof String ? source.toString() : JSON.toJSONString(source), t);
    }
}
