package com.embedded.heap;

import java.util.Comparator;

/**
 * 二叉堆
 * @author rnang0
 * @date 2020/8/16
 **/
@SuppressWarnings("unchecked")
public class BinaryHeap<E> extends AbstractHeap<E> {
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public BinaryHeap() {
        this(null,null);
    }

    public BinaryHeap(E[] elements) {
        this(elements,null);
    }

    public BinaryHeap(Comparator<E> comparator) {
        this(null,comparator);
    }

    /**
     * 数组元素堆化heapify
     * @param elements
     */
    public BinaryHeap(E[] elements, Comparator<E> comparator) {

        if (elements == null || elements.length == 0) {
            this.elements = (E[]) new Object[DEFAULT_CAPACITY];
        } else {
            int capacity = Math.max(elements.length,DEFAULT_CAPACITY);
            this.elements = (E[]) new Object[capacity];
            System.arraycopy(elements, 0, this.elements, 0, elements.length);
            size = this.elements.length;
            heapify();
        }
    }

    /**
     * 批量建堆
     */
    private void heapify() {
        // 采用自下而上的下滤
        for (int i = (size >> 1) - 1; i >= 0; i--) {
            siftDown(i);
        }
    }

    @Override
    public void clear() {
        size = 0;
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
    }

    /**
     * 获取堆顶元素
     * @return
     */
    @Override
    public E get() {
        emptyCheck();
        return elements[0];
    }

    private void emptyCheck() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Heap is empty!");
        }
    }

    @Override
    public void add(E element) {
        // 判定null
        elementNotNullCheck(element);

        // 看有size + 1个位置？
        ensureCapacity(size + 1);

        elements[size] = element;
        size++;
        // 上滤调整
        siftUp(size - 1);
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
        E[] newElement = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElement[i] = (E) elements[i];
        }
        elements = newElement;
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must no be null!");
        }
    }

    /**
     * 让某一个位置节点上滤
     * @param index
     */
    private void siftUp(int index) {
        E element = elements[index];
        while (index > 0) {
            int parentIndex = (index - 1) >> 1;
            E parentElement = elements[parentIndex];
            if (compare(element, parentElement) <= 0) {
                break;
            }

            // 父节点元素覆盖子节点
            elements[index] = parentElement;
            index = parentIndex;
        }
        elements[index] = element;
    }

    /**
     * 删除堆顶节点
     * @return
     */
    @Override
    public E remove() {
        emptyCheck();
        // 拿最后一个节点（index为size - 1）覆盖堆顶
        E result = elements[0];
        int lastIndex = size - 1;
        elements[0] = elements[lastIndex];
        elements[lastIndex] = null;
        size--;
        // 下滤最后一个节点
        siftDown(0);

        return result;
    }

    /**
     * 让某一个位置节点下滤
     * @param index
     */
    private void siftDown(int index) {
        E element = elements[index];
        int halfIndex = size >> 1;
        // index要小于第一个叶子节点的索引
        while (index < halfIndex) {
            // 左子节点
            int childIndex = (index << 1) + 1;
            E childElement = elements[childIndex];

            // 判定是否有右节点，且比较左节点值，选最大值
            int rightIndex = childIndex + 1;
            if (rightIndex < size && compare(elements[rightIndex],childElement) > 0) {
                childElement = elements[childIndex = rightIndex];
            }

            if (compare(element,childElement) >= 0) {
                break;
            }

            elements[index] = childElement;
            index = childIndex;
        }
        elements[index] = element;
    }

    /**
     * 删除堆顶，且添加新元素
     * @param element
     * @return
     */
    @Override
    public E replace(E element) {
        elementNotNullCheck(element);
        E top = null;

        if (size == 0) {
            elements[0] = element;
            top = elements[0];
        } else {
            top = get();
            //添加进堆顶，然后下滤堆化
            elements[0] = element;
            siftDown(0);
        }
        size++;
        return top;
    }

}
