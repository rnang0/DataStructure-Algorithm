package com.embedded;

import com.embedded.sorting.BubbleSort;
import com.embedded.sorting.HeapSort;
import com.embedded.sorting.SelectionSort;

import java.nio.channels.SelectionKey;

/**
 * 排序测试
 * @author rnang0
 * @date 2020/8/18
 **/
public class Main {

    private static final int[] ARRAY = {3, 2, 30, 1, 23, 33 ,34, 35, 66, 77};

    public static void main(String[] args) {
        int[] array = ARRAY;
        // 1. 使用冒泡排序
        //BubbleSort bubbleSort = new BubbleSort();
        //bubbleSort.sort(array);

        // 2. 使用选择排序
        //SelectionSort selectionSort = new SelectionSort();
        //selectionSort.sort(array);

        // 3. 选择堆排序
        HeapSort heapSort = new HeapSort();
        heapSort.sort(array);
    }

}
