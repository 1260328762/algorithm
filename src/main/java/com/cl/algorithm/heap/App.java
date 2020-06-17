package com.cl.algorithm.heap;

import com.cl.algorithm.heap.timer.MySchedule;

/**
 * @author chenliang
 * @date 2020-06-11
 */
public class App {
    public static void main(String[] args) throws Exception {

        MySchedule schedule = new MySchedule();
        schedule.schedule(System.currentTimeMillis() + 5000, new Runnable() {
            @Override
            public void run() {
                System.out.println("我是测试任务1");
            }
        });


        schedule.run();

        System.in.read();
    }
}
