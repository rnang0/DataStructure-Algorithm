package com.embedded.binarysearchtree;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉搜索树
 * @author rnang0
 * @date 2020/8/13
 **/
public class BinarySearchTree<E> extends BinaryTree<E>{

    private Comparator<E> comparator;

    public BinarySearchTree() {
        this(null);
    }
    /**
     * 外部传入比较器
     * @param comparator
     */
    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public boolean contains(E element) {
        return node(element) != null;
    }

    /**
     * 根据值找到对应的节点
     * @param element
     * @return
     */
    public Node<E> node(E element) {
        Node<E> node = root;

        while (node != null) {
            int cmp = compare(element, node.element);
            if (cmp == 0) {
                return node;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                node = node.left;
            }
        }

        return null;
    }

    public void add(E element) {
        elementNotNullCheck(element);

        // 找到父节点
        // node为用来遍历的节点，parent为结果父节点
        Node<E> node = root;
        Node<E> parent = null;
        int cmp = 0;

        while (node != null) {
            cmp = compare(element, node.element);
            parent = node;

            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else {
                // 已经有了，可以直接返回
                node.element = element;
                return;
            }
        }

        // 在node引用处，添加值element（新建节点）
        Node<E> newNode = new Node<>(element, parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else if (cmp < 0) {
            parent.left = newNode;
        } else {
            // 添加的是第一个节点
            root = newNode;
        }
        size++;
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null!");
        }
    }

    private int compare(E element1, E element2) {
        if (comparator != null) {
            return comparator.compare(element1,element2);
        }
        // 调用默认元素类的比较器
        return ((Comparable<E>)element1).compareTo(element2);
    }

    /**
     * 获取树的高度，用递归实现
     * @return
     */
    public int height1() {
        return height(root);
    }

    /**
     * 获取某一节点的高度
     * @param node
     * @return
     */
    public int height(Node<E> node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(height(node.left), height(node.right));
    }

    /**
     * 获取树的高度，用层序遍历迭代
     * @return
     */
    public int height2() {
        if (root == null) {
            return 0;
        }
        int height = 0;
        // 每一层的数量（默认根结点，则为1）
        int levelSize = 1;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            levelSize--;

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }

            // 当前层遍历完，访问下一层
            if (levelSize == 0) {
                levelSize = queue.size();
                height++;
            }
        }
        return height;
    }

    public void remove(E element) {
        remove(node(element));
    }

    public void remove(Node<E> node) {
        if (node == null) {
            return;
        }

        size--;
        // 度为2的节点，找前驱或者后继
        if (node.hasTwoChildren()) {
            Node<E> pre = predecessor(node);
            node.element = pre.element;
            // 删除pre节点
            node = pre;
        }

        // 删除度为1或者0的pre节点（先赋值给node）
        Node<E> deleteNode = node.left != null ? node.left : node.right;

        // 度为1
        if (deleteNode != null) {
            // 更改parent
            deleteNode.parent = node.parent;
            // 更改parent的left、right指向
            if (node.parent == null) {
               root = deleteNode;
            } else if (node == node.parent.left) {
                node.parent.left = deleteNode;
            } else {
                node.parent.right = deleteNode;
            }

        } else if (node.parent == null) {
            root = null;
        } else {
            // node是叶子节点，但不是根结点，有父节点
            if (node == node.parent.left) {
                node.parent.left = null;
            } else {
                node.parent.right = null;
            }
        }
    }

}
