package com.project.threadClass;

public class ClassThreadDemo {

    public static void main(String[] args) throws InterruptedException {

        MyThreadByExtend thd = new MyThreadByExtend();
        thd.start();

        Runnable myRunable = new ThreadByRunable();
        Thread thd1 = new Thread(myRunable);
        thd1.start();


        System.out.println("Main programm : " +Thread.currentThread().getName());
    }

}
