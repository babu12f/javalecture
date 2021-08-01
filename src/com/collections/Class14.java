package com.collections;


import java.util.*;

public class Class14 {

    public static void main(String[] args) {

        Queue<Person> myQueue = new PriorityQueue<>();

        Person p1 = new Person("sumon", 30);
        Person p2 = new Person("mazammel", 27);
        Person p3 = new Person("kz", 49);

        myQueue.add(p1);
        myQueue.add(p2);
        myQueue.add(p3);

        System.out.println(myQueue.peek().getName());

    }
}

class Person implements Comparable<Person> {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        return this.age.compareTo(o.age);
    }
}