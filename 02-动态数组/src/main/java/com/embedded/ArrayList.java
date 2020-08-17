package com.embedded;

import java.util.Arrays;

/**
 * 动态数组实现
 * @author yWX956175
 * @version [v1.0, 2020/8/7]
 * @since 2020/8/7
 */
public class ArrayList<T> {
    private int size;
    private Object[] elements;

    private static final int DEFAULT_CAPACITY = 10;

    private static final Object[] EMPTY_VALUE = {};

    public static final int ELEMENT_NOT_FOUND = -1;

    public ArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            elements = (T[]) new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            elements = EMPTY_VALUE;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException" + index);
        }
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException" + index);
        }
    }

    public boolean contains(T element) {
        return indexOf(element) >= 0;
    }

    public T get(int index) {
        rangeCheck(index);
        return (T) elements[index];
    }

    public T set(int index, T element) {
        rangeCheck(index);
        T old = (T) elements[index];
        elements[index] = element;
        return old;
    }

    public void add(T element) {
        add(size, element);
    }

    public void add(int index, T element) {
        rangeCheckForAdd(index);

        //查看个数加1是否超过数组容量，不够就扩容
        ensureCapacity(size + 1);
//        for (int i = size - 1; i >= index; i--) {
//            elements[i + 1] = elements[i];
//        }
        System.arraycopy(elements,index,elements, index + 1,size - index);
        elements[index] = element;
        size++;
    }

    /**
     * 扩容
     * @param capacity
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) {
            return;
        }
        //新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        T[] newElement = (T[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElement[i] = (T) elements[i];
        }
        elements = newElement;
    }

    /**
     * 缩容
     */
    public void trim() {
        int capacity = elements.length;
        int newCapacity = capacity - (capacity >> 1);
        // 元素超一半，或者容量太小
        if (size >= (capacity >> 1) || capacity <= DEFAULT_CAPACITY) {
            return;
        }

        T[] newElement = (T[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElement[i] = (T) elements[i];
        }
    }

    public T remove(int index) {
        rangeCheck(index);
        T result = (T) elements[index];
//        for (int i = index + 1; i < size; i++) {
//            elements[i - 1] = elements[i];
//        }
        System.arraycopy(elements,index + 1,elements,index,size - index);
        size--;
        elements[size] = null;
        return result;
    }

    public int indexOf(T element) {
        // 可能传进来的参数为空
        if (element == null) {
            for (int i = 0; i < size; i++) {
                // 默认就是比较内存地址
                if (elements[i] == (null)) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                // 默认就是比较内存地址
                if (element.equals(elements[i])) {
                    return i;
                }
            }
        }

        return ELEMENT_NOT_FOUND;
    }

    public void clear() {
        // 如果是置为空数组的话，后面还要加东西的，只需覆盖即可
        // 其他函数开始要判size == 0
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public String toString() {
        return "DynamicArray{" +
                "size=" + size +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }
}

