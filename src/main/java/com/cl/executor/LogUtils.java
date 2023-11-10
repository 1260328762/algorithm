package com.cl.executor;

/**
 * @author chenliang
 * @since 2023/9/22 16:43
 */
public class LogUtils {

    private final StringBuffer builder = new StringBuffer();

    public void log(String message) {
        builder.append(message + "\n");
    }

    public String getResult() {
        return builder.toString();
    }
}
