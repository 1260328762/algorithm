package com.cl.algorithm.sort;

import java.io.*;

/**
 * @author chenliang
 * @date 2020-05-26
 * 线性排序方法
 */
public class LinearSort {

    /**
     * 桶排序
     * 桶排序适用于内存外排序， 假设外部文件中包含了一亿个整数数据，占用内存900M，
     * 将此文件划分为10个小文件，每个文件存放指定范围的数据，然后依次读取10个文件
     * 对文件数据进行排序，然后输出到同一个文件中
     *
     * @param path            需要排序的文件地址
     * @param destinationPath 排完序后的文件地址
     */
    public static void bucketSort(String path, String destinationPath) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        BufferedWriter[] tempStreams = new BufferedWriter[10];
        String tempDir = "C:\\Users\\Administrator\\Desktop\\sort\\";
        for (int i = 0; i < 10; i++) {
            tempStreams[i] = new BufferedWriter(new FileWriter(tempDir + i));
        }

        String s;
        while ((s = reader.readLine()) != null) {
            int value = Integer.parseInt(s);
            BufferedWriter writer = tempStreams[getIndex(value)];
            writer.write(String.valueOf(value));
            writer.newLine();
        }

        for (BufferedWriter tempStream : tempStreams) {
            tempStream.close();
        }

        mergeFile(tempDir, destinationPath);
    }

    private static void mergeFile(String tempDir, String destinationPath) throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter(destinationPath, true));
        for (int i = 0; i < 10; i++) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(tempDir + i));
            int[] arr = bufferedReader.lines().mapToInt(Integer::parseInt).toArray();
            String str;
            int index = 0;
            while ((str = bufferedReader.readLine()) != null) {
                arr[index++] = Integer.parseInt(str);
            }
            bufferedReader.close();
            new File(tempDir + i).delete();

            Sort.mergeSort(arr);

            for (int i1 : arr) {
                writer.write(String.valueOf(i1));
                writer.newLine();
            }
        }
        writer.close();
    }

    private static int getIndex(int value) {
        int start = 0;
        for (int i = 0; i < 10; i++) {
            int end = (i + 1) * 8000000;
            if (start <= value && value <= end) {
                return i;
            }
            start = end + 1;
        }
        return -1;
    }


    /**
     * 计数排序
     *
     * @param arr
     */
    public static void countingSort(int[] arr) {
        int max = arr[0];
        for (int data : arr) {
            if (data > max)
                max = data;
        }

        int[] countArr = new int[max + 1];

        for (int data : arr) {
            countArr[data] = countArr[data] + 1;
        }

        for (int i = 1; i < countArr.length; i++) {
            countArr[i] = countArr[i] + countArr[i - 1];
        }

        int[] temp = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int data = arr[i];
            int count = countArr[data];

            temp[count - 1] = data;
            countArr[data] = count - 1;
        }
        System.arraycopy(temp, 0, arr, 0, temp.length);
    }

    /**
     * 基数排序
     *
     * @param arr
     */
    public static void radixSort(int[] arr) {
        int length = 11;
        for (int i = 1; i <= length; i++) {
            for (int j = arr.length - 1; j >= 0; j--) {
                countingSort(arr, j);
            }
        }
    }


    public static void countingSort(int[] arr, int index) {
        int max = getData(arr[0], index);
        for (int data : arr) {
            if (getData(data, index) > max)
                max = getData(data, index);
        }

        int[] countArr = new int[max + 1];

        for (int data : arr) {
            countArr[getData(data, index)] = countArr[getData(data, index)] + 1;
        }

        for (int i = 1; i < countArr.length; i++) {
            countArr[i] = countArr[i] + countArr[i - 1];
        }

        int[] temp = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int realData = arr[i];
            int data = getData(arr[i], index);
            int count = countArr[data];

            temp[count - 1] = realData;
            countArr[data] = count - 1;
        }
        System.arraycopy(temp, 0, arr, 0, temp.length);
    }

    private static int getData(Integer data, int index) {
        return Integer.parseInt(complete(String.valueOf(data), 9).substring(index, index + 1));
    }

    private static String complete(String str, int length) {
        if (str.length() < length) {
            StringBuilder builder = new StringBuilder(str);
            for (int i = str.length(); i < length; i++) {
                builder.append("0");
            }
            return builder.toString();
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println("abc".substring(1, 2));
    }

}
