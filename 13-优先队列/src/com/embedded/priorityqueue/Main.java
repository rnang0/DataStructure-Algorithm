package com.embedded.priorityqueue;

/**
 * @author rnang0
 * @date 2020/8/16
 **/
public class Main {

    public static void main(String[] args) {
        PriorityQueue<Person> queue = new PriorityQueue<>();

        queue.offer(new Person(1,"java"));
        queue.offer(new Person(2,"go"));
        queue.offer(new Person(3,"c"));
        queue.offer(new Person(4,"c++"));
        queue.offer(new Person(5,"python"));

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
