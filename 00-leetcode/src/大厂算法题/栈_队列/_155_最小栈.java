package ���㷨��.ջ_����;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/min-stack/
 * @author rnang0
 * @date 2020/9/14
 **/
public class _155_��Сջ {

    /**
     * ��ȡջ����СԪ�أ�O��1�����Ӷȣ����ÿռ任ʱ��
     * ά������ջ������һ��ջminStack��ǰn��Ԫ�ص���Сֵ
     */
    class MinStack {

        private Stack<Integer> stack;

        private Stack<Integer> minStack;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty()) {
                minStack.push(x);
            } else {
                Integer top = minStack.peek();
                if (x <= top) {
                    minStack.push(x);
                } else {
                    minStack.push(top);
                }
            }
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
