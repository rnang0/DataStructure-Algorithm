package com.embedded.avltree;

import com.embedded.binarysearchtree.BinarySearchTree;

import java.util.Comparator;

/**
 * 平衡二叉搜索树
 * @author rnang0
 * @date 2020/8/15
 **/
public class AVLTree<E> extends BinarySearchTree<E> {

    public AVLTree() {
        this(null);
    }

    /**
     * 外部传入比较器
     * @param comparator
     */
    public AVLTree(Comparator<E> comparator) {
        super(comparator);
    }


}
