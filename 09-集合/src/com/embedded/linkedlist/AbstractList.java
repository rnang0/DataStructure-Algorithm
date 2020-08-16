package com.embedded.linkedlist;

/**
 * @author rnang0
 * @date 2020/8/8
 **/
public abstract class AbstractList<E> {
    protected int size;

    public void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException" + index);
        }
    }

    public void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException" + index);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


}
