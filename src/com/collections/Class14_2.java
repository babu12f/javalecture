package com.collections;

public class Class14_2 {
    public static void main(String[] args) {
        Planet jp = Planet.JUPYTER;
        System.out.println(jp);
        jp.someMethod("hello");
    }
}

enum Planet{
    EARTH(1),
    MARSH(2),
    PLUTO(3),
    NEPTUNE(4),
    JUPYTER(5);

    int val;
    Planet(int val) {
        this.val = val;
    }

    public void someMethod(String s) {
        System.out.println(this.val + "some method " + s);
    }
}