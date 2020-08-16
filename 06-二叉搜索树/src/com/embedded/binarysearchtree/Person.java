package com.embedded.binarysearchtree;

import java.util.Comparator;

/**
 * @author rnang0
 * @date 2020/8/14
 **/
public class Person implements Comparator<Person> {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compare(Person o1, Person o2) {
        return o1.age - o2.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }
}
