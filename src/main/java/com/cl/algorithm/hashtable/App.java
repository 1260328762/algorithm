package com.cl.algorithm.hashtable;

/**
 * @author chenliang
 * @date 2020-06-01
 */
public class App {
    public static void main(String[] args) {
        // HashTable<String, Integer> hashTable = new HashTable<>();
        //         // HashMap<String, Integer> map = new HashMap<>();
        //         // String[] str = new String[]{"baidu", "google", "tianya", "jianshu", "zhihu", "geek", "system",
        //         //         "git", "github", "algo", "idea", "python"};
        //         // for (int i = 0; i < str.length; i++) {
        //         //     map.put(str[i], i);
        //         // }

        int size = 10000000;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }

        int[] arr2 = new int[size];
        int[] arr3 = new int[size];
        long l = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr2[i] = arr[i];
            // arr3[i] = arr[i];
        }

        // for (int i = 0; i < size; i++) {
        //     arr3[i] = arr[i];
        // }
        System.out.println(System.currentTimeMillis() - l);


        // String name = "chenliang";
        // Optional<String> optional = Optional.of(name);
        // System.out.println(optional.orElse(getValue()));
        // System.out.println(optional.orElseGet(App::getValue));
    }

    public static String getValue(){
        System.out.println("create value");
        return "Test";
    }
}
