package com.cl.question;

import java.util.Map;

/**
 * @author chenliang
 * @since 2022/11/6 16:06
 * Thread.getAllStackTraces() can output stacktrace info just like jstat command
 */
public class StackTraceTest {
    public static void main(String[] args) {
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();

        for (Map.Entry<Thread, StackTraceElement[]> threadEntry : allStackTraces.entrySet()) {
            System.out.println("Thread: " + threadEntry.getKey());
            for (StackTraceElement stackTraceElement : threadEntry.getValue()) {
                System.out.println("stackTraceElement: " + stackTraceElement);
            }
        }
    }
}
