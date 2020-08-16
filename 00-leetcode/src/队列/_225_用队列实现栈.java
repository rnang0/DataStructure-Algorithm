package 队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 * @author rnang0
 * @date 2020/8/13
 **/
public class _225_用队列实现栈 {

    private Queue<Integer> inQueue;

    private Queue<Integer> outQueue;

    /** Initialize your data structure here. */
    public _225_用队列实现栈() {
        inQueue = new LinkedList<Integer>();
        outQueue = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        inQueue.offer(x);
        while (!outQueue.isEmpty()) {
            inQueue.offer(outQueue.poll());
        }
        Queue<Integer> temp = inQueue;
        inQueue = outQueue;
        outQueue = temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return outQueue.poll();
    }

    /** Get the top element. */
    public int top() {
        return outQueue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return inQueue.isEmpty() && outQueue.isEmpty();
    }
}
