package com.cl.operationlog;

import com.alibaba.fastjson.JSONObject;
import com.cl.algorithm.util.JsonUtils;

import java.util.*;

/**
 * @author chenliang
 * @since 2023/12/4 17:24
 */
public class OperationLogger {

    private static final ThreadLocal<Map<String, OperationLogContent>> logContentThreadLocal = ThreadLocal.withInitial(HashMap::new);


    public static void logSinglePreValue(String fieldName, Object preValue) {
        Map<String, OperationLogContent> contentMap = logContentThreadLocal.get();

        OperationLogContent operationLogContent = contentMap.get(fieldName);
        if (operationLogContent == null) {
            operationLogContent = new OperationLogContent()
                    .setFieldName(fieldName)
                    .setPreValue(preValue);
        } else {
            operationLogContent.setPreValue(preValue);
        }
        contentMap.put(fieldName, operationLogContent);
    }


    public static void logSingleCurValue(String fieldName, Object curValue) {
        Map<String, OperationLogContent> contentMap = logContentThreadLocal.get();

        OperationLogContent operationLogContent = contentMap.get(fieldName);
        if (operationLogContent == null) {
            operationLogContent = new OperationLogContent()
                    .setFieldName(fieldName)
                    .setCurValue(curValue);
        } else {
            operationLogContent.setCurValue(curValue);
        }
        contentMap.put(fieldName, operationLogContent);
    }

    public static void logPreValue(Object preValue, String... excludeFields) {
        Map<String, OperationLogContent> contentMap = logContentThreadLocal.get();

        JSONObject preObject = JsonUtils.toBean(preValue, JSONObject.class);
        List<OperationLogContent> logContentList = new ArrayList<>();
        preObject.forEach((key, value) -> {
            if (Arrays.asList(excludeFields).contains(key)) return;

            OperationLogContent operationLogContent = new OperationLogContent()
                    .setFieldName(key)
                    .setPreValue(value);
            OperationLogContent existLogContent = contentMap.get(key);
            if (existLogContent != null) {
                operationLogContent.setCurValue(existLogContent.getCurValue());
            }
            logContentList.add(operationLogContent);
        });

        logContentList.forEach(logContent -> contentMap.put(logContent.getFieldName(), logContent));
    }

    public static void logCurValue(Object curValue, String... excludeFields) {
        Map<String, OperationLogContent> contentMap = logContentThreadLocal.get();

        JSONObject preObject = JsonUtils.toBean(curValue, JSONObject.class);
        List<OperationLogContent> logContentList = new ArrayList<>();
        preObject.forEach((key, value) -> {
            if (Arrays.asList(excludeFields).contains(key)) return;

            OperationLogContent operationLogContent = new OperationLogContent()
                    .setFieldName(key)
                    .setCurValue(value);
            OperationLogContent existLogContent = contentMap.get(key);
            if (existLogContent != null) {
                operationLogContent.setPreValue(existLogContent.getPreValue());
            }
            logContentList.add(operationLogContent);
        });

        logContentList.forEach(logContent -> contentMap.put(logContent.getFieldName(), logContent));
    }

    public static void logSingleValue(String fieldName, Object preValue, Object curValue) {
        logSinglePreValue(fieldName, preValue);
        logSingleCurValue(fieldName, curValue);
    }

    public static void logValue(Object preValue, Object curValue, String... excludeFields) {
        logPreValue(preValue, excludeFields);
        logCurValue(curValue, excludeFields);
    }

    public static List<OperationLogContent> getLogContents() {
        return new ArrayList<>(logContentThreadLocal.get().values());
    }

    public static void clear() {
        logContentThreadLocal.remove();
    }
}
