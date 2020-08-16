package com.embedded.linkedlist.impl;

import com.embedded.linkedlist.AbstractList;
import com.embedded.linkedlist.List;

/**
 * 03-链表
 * @author rnang0
 * @date 2020/8/8
 **/
public class LinkedList<E> extends AbstractList<E> implements List<E> {

    private Node<E> first;

    private Node<E> last;

    public static final int ELEMENT_NOT_FOUND = -1;

    /**
     * 节点信息
     * @param <E>
     */
    private static class Node<E> {
        E element;
        Node<E> pre;
        Node<E> next;

        public Node(Node<E> pre, E element, Node<E> next) {
            this.pre = pre;
            this.element = element;
            this.next = next;
        }
    }

    /**
     * 获取index位置的对象
     * @param index
     * @return
     */
    private Node<E> node(int index) {
        rangeCheckForAdd(index);

        if (index < (size >> 1)) {
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.pre;
            }
            return node;
        }
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    /**
     * 获得该值的索引
     * @param element
     * @return
     */
    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        // 可能传进来的参数为空
        if (element == null) {
            for (int i = 0; i < size; i++) {
                // 默认就是比较内存地址
                if (node.element == element) {
                    return i;
                }
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                // 默认就是比较内存地址
                if (element.equals(node.element)) {
                    return i;
                }
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> nodeOfIndex = node(index);
        E oldElement = nodeOfIndex.element;
        nodeOfIndex.element = element;
        return oldElement;
    }

    @Override
    public void add(E element) {
        add(size,element);
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);

        if (index == size) {
            Node<E> oldLast = last;
            // 新的尾结点
            last = new Node<>(oldLast,element,null);
            // 添加前为空
            if (oldLast == null) {
                first = last;
            } else {
                oldLast.next = last;
            }
        } else {
            Node<E> next = node(index);
            Node<E> pre = next.pre;
            Node<E> node = new Node<>(pre,element,next);
            next.pre = node;

            if (pre == null) {
                first = node;
            } else {
                pre.next = node;
            }
        }
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = node(index);
        Node<E> pre = node.pre;
        Node<E> next = node.next;
        // 判断临界条件
        if (pre == null) {
            first = next;
        } else {
            pre.next = next;
        }

        if (next == null) {
            last = pre;
        } else {
            next.pre = pre;
        }
        size--;
        return node.element;
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("size=").append(size).append(",[");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                builder.append(",");
            }
            builder.append(node.element);
            node = node.next;
        }
        builder.append("]");
        return builder.toString();
    }
}
