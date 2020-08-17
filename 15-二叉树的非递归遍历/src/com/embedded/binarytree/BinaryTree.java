package com.embedded.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树非递归遍历
 * @author rnang0
 * @date 2020/8/17
 **/
public class BinaryTree<E> {

    protected Node<E> root;

    protected int size;

    protected static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public boolean hasTwoChildren() {
			return left != null && right != null;
		}
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 前序遍历非递归，栈实现
     * @param visitor
     */
    public void preorder(Visitor<E> visitor) {
        if (visitor == null || root == null) {
            return;
        }

        Node<E> node = root;
        Stack<Node<E>> stack = new Stack<>();

        while (true) {
            if (node != null) {
                // 访问器返回true就停止
                if (visitor.visit(node.element)) {
                    return;
                }
                // 有右子节点就入栈
                if (node.right != null) {
                    stack.push(node.right);
                }
                node = node.left;
            } else if (stack.isEmpty()){
                return;
            } else {
                // 右子节点开始遍历
                node = stack.pop();
            }
        }
    }

    /**
     * 中序遍历非递归，栈实现
     * @param visitor
     */
    public void inorder(Visitor<E> visitor){
        if (root == null || visitor == null) {
            return;
        }

        Node<E> node = root;
        Stack<Node<E>> stack = new Stack<>();

        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else if (stack.isEmpty()) {
                return;
            } else {
                node = stack.pop();
                if (visitor.visit(node.element)) {
                    return;
                }
                // 让右节点进行中序遍历
                node = node.right;
            }
        }
    }

    /**
     * 后序遍历非递归
     */
    public void postOrder(Visitor<E> visitor){
        if (root == null || visitor == null) {
            return;
        }
        Node<E> prev = null;
        Stack<Node<E>> stack = new Stack<>();
        stack.push(root);

        // 一路往左入栈
        while (!stack.isEmpty()) {
            Node<E> top = stack.peek();
            if (top.isLeaf() || (prev != null && prev.parent == top)) {
                // 弹出访问节点
                prev = stack.pop();
                if (visitor.visit(prev.element)) {
                    return;
                }
            } else {
                if (top.right != null) {
                    stack.push(top.right);
                }

                if (top.left != null) {
                    stack.push(top.left);
                }
            }


        }
    }

    /**
     * 层序遍历
     * 根结点入队，循环执行判定，直到队列为空
     * 队头出队，访问，然后队头的左右节点入队
     * @param visitor 访问器
     */
    public void levelOrderTraversal(Visitor<E> visitor) {
        if (root == null || visitor ==null) {
            return;
        }

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            visitor.visit(node.element);

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public static interface Visitor<E> {

        /**
         * 遍历访问接口，返回true就停止遍历
         * @param element
         * @return
         */
        boolean visit(E element);
    }

    /**
     * 返回node中序遍历的前驱节点
     * @param node
     * @return
     */
    protected Node<E> predecessor(Node<E> node) {
        if (node == null) {
            return null;
        }

        // 左子树中最大的（就是node前面一个的值）
        Node<E> p = node.left;

        if (p != null) {
            while (p.right != null) {
                p = p.right;
            }
            return p;
        }

        // 没有左节点
        while (node.parent != null && node == node.parent.left) {
            node = node.parent;
        }

        return node.parent;
    }

    /**
     * 返回node中序遍历的后继节点
     * @param node
     * @return
     */
    protected Node<E> successor(Node<E> node) {
        if (node == null) {
            return null;
        }

        // 左子树中最大的（就是node前面一个的值）
        Node<E> p = node.right;

        if (p != null) {
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }

        // 没有左节点
        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }

        return node.parent;
    }

    /**
     * 判断是否为完全二叉树，层序遍历实现
     * @return
     */
    public boolean isComplete() {
        if (root == null) {
            return false;
        }

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        boolean leaf = false;
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            // 要求是叶子但不是叶子
            if (leaf && !node.isLeaf()) {
                return false;
            }

            if (node.left != null && node.right != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            } else if (node.left == null && node.right != null) {
                return false;
            } else { //后面必须为叶子节点，安排你必须为叶子
                if (node.left != null) {
                    queue.offer(node.left);
                }
                leaf = true;
            }
        }
        return true;
    }

}
