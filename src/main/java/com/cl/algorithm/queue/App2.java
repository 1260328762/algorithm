package com.cl.algorithm.queue;

import lombok.SneakyThrows;

import java.util.Random;

/**
 * @author chenliang
 * @date 2020-07-09
 */
public class App2 {
    public static void main(String[] args) {
        CircularQueue<Integer> queue = new CircularQueue<>(10);

        new Thread(){
            @SneakyThrows
            @Override
            public void run() {
                int i = 0;
                Random random = new Random();
                while (true) {
                    if (queue.push(i)) {
                        System.out.println("生产数据: " + i);
                    }
                    Thread.sleep(300 + random.nextInt(200));
                    i++;
                }
            }
        }.start();


        new Thread(){
            @SneakyThrows
            @Override
            public void run() {
                int i = 0;
                Random random = new Random();
                while (true) {
                    if (queue.pop() != null) {
                        System.out.println("消费数据: " + i);
                    }
                    Thread.sleep(300 + random.nextInt(200));
                    i++;
                }
            }
        }.start();


        System.out.println(queue.pop());
    }
}
