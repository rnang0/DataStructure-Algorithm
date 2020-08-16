package com.embedded.statck;

import com.embedded.DynamicArray;

/**
 * @author rnang0
 * @date 2020/8/12
 **/
public class Stack<E> extends DynamicArray<E> {

    public void push(E element) {
        add(element);
    }

    public E pop() {
        return remove(size() - 1);
    }

    public E top() {
        return get(size() - 1);
    }
}
