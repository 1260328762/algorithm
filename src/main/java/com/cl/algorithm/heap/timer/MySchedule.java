package com.cl.algorithm.heap.timer;


import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.locks.LockSupport;
import java.util.function.ToLongFunction;

/**
 * @author chenliang
 * @date 2020-06-17
 * 利用堆实现定时任务，堆顶元素永远是最先开始执行的任务
 */
public class MySchedule implements Runnable {

    private PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();

    private Thread thread;

    public void schedule(long time, Runnable runnable) {
        queue.offer(new Task(time, runnable));
        if (thread != null) {
            thread.interrupt();
        }
    }

    @Override
    public void run() {
        while (true) {
            Task peek = queue.poll();
            if (peek != null) {
                if (peek.time <= System.currentTimeMillis()) {
                    System.out.println("运行任务：" + peek);

                } else {
                    long waitTime = peek.time - System.currentTimeMillis();
                    try {
                        thread = Thread.currentThread();
                        Thread.sleep(waitTime);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                new Thread(peek.runnable).start();
            }
        }
    }







    private static class Task implements Comparable<Task>{
        private long time;
        private Runnable runnable;

        public Task(long time, Runnable runnable) {
            this.time = time;
            this.runnable = runnable;
        }

        @Override
        public int compareTo(Task o) {
            return Comparator.comparingLong((ToLongFunction<Task>) value -> value.time).compare(this, o);
        }

        @Override
        public String toString() {
            return "Task{" +
                    "time=" + time +
                    ", runnable=" + runnable +
                    '}';
        }
    }



}
