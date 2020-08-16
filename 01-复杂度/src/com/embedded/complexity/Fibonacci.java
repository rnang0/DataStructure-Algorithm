package com.embedded.complexity;
/**
 * Fibonacci数列的优化
 *
 * @author yWX956175
 * @version [v1.0, 2020/8/6]
 * @since 2020/8/6
 */
public class Fibonacci {

    /**
     * fibonacci 数列的递归实现
     * @param n
     * @return
     */
    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }

    /**
     * fibonacci 的迭代实现
     * @param n
     * @return
     */
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        int first = 0;
        int second = 1;
        for (int i = 0; i < n - 1; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(75));
    }
}
