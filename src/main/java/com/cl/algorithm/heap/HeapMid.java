package com.cl.algorithm.heap;

/**
 * @author chenliang
 * @date 2020-06-16
 * 用堆求中位数
 */
public class HeapMid {

    /**
     * 大顶堆
     */
    private ArrayHeap bigHeap;

    /**
     * 小顶堆
     */
    private ArrayHeap smallHeap;

    public HeapMid(){
        bigHeap = new ArrayHeap(100, 0);
        smallHeap = new ArrayHeap(100, 1);
    }


    public void add(int data) {
        if (data < bigHeap.head()) {
            bigHeap.add(data);
        } else
            smallHeap.add(data);
        balance();
    }

    public double mid(){
        int total = bigHeap.size() + smallHeap.size();
        if (total % 2 == 0) {
            return ((double) (bigHeap.head() + smallHeap.head()) / 2);
        }
        return smallHeap.head();
    }


    private void balance(){
        int total = bigHeap.size() + smallHeap.size();

        // 总量为偶数
        if (total % 2 == 0) {
            if (bigHeap.size() != smallHeap.size()) {
                if (bigHeap.size() > smallHeap.size())
                    transfer(bigHeap, smallHeap);
                else
                    transfer(smallHeap, bigHeap);
            }
        } else {
            if (bigHeap.size() != smallHeap.size() - 1) {
                if (bigHeap.size() >= smallHeap.size()) {
                    transfer(bigHeap, smallHeap);
                } else if (bigHeap.size() + 1 < smallHeap.size()) {
                    transfer(smallHeap, bigHeap);
                }
            }
        }
    }

    private void transfer(ArrayHeap src, ArrayHeap dest) {
        dest.add(src.popHead());
    }

}
