package com.cl.algorithm.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenliang
 * @since  2020-05-19
 * 阻塞队列
 */
public class BlockingQueue<T> {

    private CircularQueue<T> queue;

    public static ReentrantLock lock;

    public Condition fullCondition;

    public Condition emptyCondition;

    public BlockingQueue(int capacity){
        queue = new CircularQueue<>(capacity);
        lock = new ReentrantLock();
        fullCondition = lock.newCondition();
        emptyCondition = lock.newCondition();
    }

    public void put(T data) {
        lock.lock();
        try {
            boolean push = queue.push(data);
            if (!push) {
                fullCondition.await();
            }
            queue.push(data);
            emptyCondition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public T take(){
        lock.lock();
        try {
            if (queue.isEmpty()) {
                emptyCondition.await();
            }
            T pop = queue.pop();
            fullCondition.signal();
            return pop;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }
}
