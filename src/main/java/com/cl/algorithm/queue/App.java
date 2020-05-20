package com.cl.algorithm.queue;

import lombok.SneakyThrows;


/**
 * @author chenliang
 * @date 2020-05-19
 */
public class App {
    public static void main(String[] args) throws Exception{
        BlockingQueue<Integer> blockingQueue = new BlockingQueue<>(10);

        new Thread(){
            @SneakyThrows
            @Override
            public void run() {
                while (true) {
                    System.out.println("消费了：" + blockingQueue.take());
                    Thread.sleep(1000);
                }
            }
        }.start();



        new Thread(){
            @SneakyThrows
            @Override
            public void run() {
                while (true){
                    blockingQueue.put(2);
                    System.out.println("生产了一个2");
                    Thread.sleep(1000);
                }
            }
        }.start();

        new Thread(){
            @SneakyThrows
            @Override
            public void run() {
                while (true){
                    blockingQueue.put(3);
                    System.out.println("生产了一个3");
                    Thread.sleep(1000);
                }
            }
        }.start();




        // ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);
        // new Thread(){
        //     @SneakyThrows
        //     @Override
        //     public void run() {
        //         System.out.println(blockingQueue.take());
        //     }
        // }.start();
        //
        //
        //
        // new Thread(){
        //     @SneakyThrows
        //     @Override
        //     public void run() {
        //         Thread.sleep(3000);
        //         blockingQueue.put(2);
        //     }
        // }.start();


    }
}
