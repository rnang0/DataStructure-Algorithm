package com.embedded.queue;

import com.embedded.linkedlist.impl.LinkedList;

/**
 * 队列的学习
 * @author rnang0
 * @date 2020/8/13
 **/
public class Queue<E> extends LinkedList<E> {

    public void enQueue(E element) {
        add(element);
    }

    public E deQueue() {
        return remove(0);
    }

    public E front() {
        return get(0);
    }
}
