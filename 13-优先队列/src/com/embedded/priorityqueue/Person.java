package com.embedded.priorityqueue;

/**
 * @author rnang0
 * @date 2020/8/16
 **/
public class Person implements Comparable<Person> {

    private int boneBreak;

    private String name;

    public Person(int boneBreak, String name) {
        this.boneBreak = boneBreak;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "boneBreak=" + boneBreak +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return this.boneBreak - o.boneBreak;
    }
}
