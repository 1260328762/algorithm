package com.cl.question.stack;

/**
 * @author chenliang
 * @since 2021/12/21 10:04
 * <p>
 * 面试题 03.01. 三合一
 * 三合一。描述如何只用一个数组来实现三个栈。
 * <p>
 * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
 * <p>
 * 构造函数会传入一个stackSize参数，代表每个栈的大小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/three-in-one-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TripleInOne {

    private int[] arr;
    private int stackSize;
    private final int[] top = new int[3];

    public TripleInOne(int stackSize) {
        arr = new int[3 * stackSize];
        this.stackSize = stackSize;
        for (int i = 0; i < top.length; i++) {
            top[i] = stackSize * i;
        }
    }

    public void push(int stackNum, int value) {
        // 获取指定栈的栈顶标记
        int stackIndex = top[stackNum];
        // 判断栈是否已满
        if (stackIndex < stackSize * stackNum + stackSize) {
            arr[stackIndex] = value;
            top[stackNum] = stackIndex + 1;
        }
    }

    public int pop(int stackNum) {
        int stackIndex = top[stackNum];
        // 判断栈是否为空
        if (stackIndex == stackNum * stackSize) {
            return -1;
        }

        int result = arr[stackIndex - 1];
        top[stackNum] = stackIndex - 1;
        return result;
    }

    public int peek(int stackNum) {
        int stackIndex = top[stackNum];
        if (stackIndex == stackNum * stackSize) {
            return -1;
        }
        return arr[stackIndex - 1];
    }

    public boolean isEmpty(int stackNum) {
        return top[stackNum] == stackNum * stackSize;
    }

    public static void main(String[] args) {
        TripleInOne tripleInOne = new TripleInOne(2);
        tripleInOne.push(0, 0);
        tripleInOne.push(0, 0);
        tripleInOne.push(1, 1);
        tripleInOne.push(1, 1);
        tripleInOne.push(2, 2);
        tripleInOne.push(2, 2);


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                int pop = tripleInOne.peek(i);
                System.out.println(pop);
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                int pop = tripleInOne.pop(i);
                System.out.println(pop);
            }
        }
    }
}
