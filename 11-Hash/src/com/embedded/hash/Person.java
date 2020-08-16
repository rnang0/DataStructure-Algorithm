package com.embedded.hash;

import java.util.Objects;

/**
 * Person自定义对象
 * @author rnang0
 * @date 2020/8/16
 **/
public class Person {

    private int age;

    private float height;

    private String name;

    public Person(int age, float height, String name) {
        this.age = age;
        this.height = height;
        this.name = name;
    }

    /**
     * hash冲突时，用来比较两个对象是否相等
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        // 内存地址相等
        if (this == o) {
            return true;
        }
        // 比较的对象为null，或者双方类型都不一样
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        // 比较成员变量
        Person person = (Person) o;
        return age == person.age &&
                Float.compare(person.height, height) == 0 &&
                Objects.equals(name, person.name);
    }

    /**
     * 返回对应的hash然后计算索引
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(age, height, name);
    }
}
