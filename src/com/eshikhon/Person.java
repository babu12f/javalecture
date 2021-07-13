package com.eshikhon;

public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {

    }

    public void walk() {
        System.out.println("walking ...");
    }

    public void walk(int speed) {
        System.out.println("walking ... at speed " + speed);
    }

    public void speak() {
        System.out.println("speaking ....");
    }
}
