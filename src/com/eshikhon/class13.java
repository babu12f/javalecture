package com.eshikhon;

import com.sun.org.apache.xpath.internal.objects.XObject;

import java.util.*;

public class class13 {
    public static void main(String[] args) {
        /**
         * LinkList,
         *
         * Vector
         *
         * stack =>
         *
         * queue =>
         *
         * */
        List<String> list1 = new ArrayList<>();

        list1.add("sumon");
        list1.add("mozammel");
        System.out.println("List 1 values: "+list1);

        List<String> list2 = new ArrayList<>();
        list2.add("ali");
        list2.add("kz");
        System.out.println("List 2 values: "+list2);

        list1.add("nazrul");
        list1.addAll(0, list2);
        System.out.println("List 1 values: "+list1);



    }
}
