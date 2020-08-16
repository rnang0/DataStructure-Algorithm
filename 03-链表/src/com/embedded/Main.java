package com.embedded;

import com.embedded.linkedlist.List;
import com.embedded.linkedlist.impl.LinkedList;

/**
 * @author rnang0
 * @date 2020/8/8
 **/
public class Main {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(20);
        list.add(0,10);
        list.add(30);
        list.add(list.size(),40);

        list.remove(1);
        System.out.println(list);
    }
}
