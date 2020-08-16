package com.embedded.heap;

import java.util.Comparator;

/**
 * Top K ：获取前k个数
 * @author rnang0
 * @date 2020/8/16
 **/
public class Main {
    public static void main(String[] args) {
        // 1.新建小顶堆
        BinaryHeap<Integer> heap = new BinaryHeap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        // 2.获取前k个数
        int k = 3;
        Integer[] data = {51,23,30,92,25,/*.....*/};
        for (int i = 0; i < data.length; i++) {
            if (heap.size() < k) {
                heap.add(data[i]);
            } else if (data[i] > heap.get()){
                // 有比小顶堆大的就进去
                heap.replace(data[i]);
            }
        }
    }
}
