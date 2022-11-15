package com.cl.question;

/**
 * @author chenliang
 * @since 2022/11/15 13:59
 */
public class MultiThreadSeqPrint {

    static String reference = "A";

    public static void main(String[] args) {
        Thread a = new Thread(() -> print("A", "B", 10));
        Thread b = new Thread(() -> print("B", "C", 10));
        Thread c = new Thread(() -> print("C", "A", 10));
        a.start();
        b.start();
        c.start();
    }

    public static void print(String printString, String nextPrintString, int times) {
        for (int i = 0; i < times; i++) {
            while (true) {
                if (reference.equals(printString)) {
                    System.out.println(printString);
                    reference = nextPrintString;
                    break;
                }
            }
        }
    }
}
