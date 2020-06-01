package com.cl.algorithm;

import java.util.Collection;
import java.util.Comparator;

/**
 * @author chenliang
 * @date 2020-05-28
 */
public class SortUtil {

    public static <T> void sort(Collection<T> collection, Comparator<T> comparator){
        T[] objects = collection.toArray((T[])new Object[0]);

        int compare = comparator.compare(objects[0],objects[1]);
    }

}
