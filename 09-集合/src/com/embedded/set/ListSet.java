package com.embedded.set;

import com.embedded.linkedlist.impl.LinkedList;

/**
 * 链表实现集合
 * @author rnang0
 * @date 2020/8/15
 **/
public class ListSet<E> extends LinkedList<E> implements Set<E> {

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return isEmpty();
    }

    @Override
    public void clear() {
        clear();
    }

    @Override
    public boolean contains(E element) {
        return super.contains(element);
    }

    @Override
    public void add(E element) {
        // 判断是否重复
        int index = indexOf(element);
        if (index != ELEMENT_NOT_FOUND) {
            set(index,element);
        } else {
            super.add(element);
        }
    }

    @Override
    public void remove(E element) {
        // 判断是否重复
        int index = indexOf(element);
        if (index != ELEMENT_NOT_FOUND) {
            super.remove(index);
        }
    }

    @Override
    public void traversal(Visitor<E> visitor) {
        if (visitor == null) {
            return;
        }

        int size = size();
        for (int i = 0; i < size; i++) {
            if (visitor.visit(get(i))) {
                return;
            }
        }
    }
}
