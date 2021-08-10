package com.eshikhon;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Class16 {

    public static void main(String[] args) {

        /*StrFunction strFunction = (s) -> {
            return s + " ??";
        };

        System.out.println(strFunction.appendStr("kz"));

        MySum mysum = (a, b) -> a + b;

        System.out.println(mysum.addition(12, 10));

        CalculateSqare csq = a -> a * a;

        CalculateSqare sqare = new CalculateSqareImpl();

        System.out.println(csq.square(2));*/

        List<Integer> dataList = new ArrayList<>();
        dataList.add(23);
        dataList.add(230);
        dataList.add(283);
        dataList.add(500);

        myClass mc = new myClass();
        dataList.forEach(mc);
        dataList.forEach(mc);
    }
}

class myClass implements Consumer<Integer> {

    @Override
    public void accept(Integer a) {
        if (a%2 == 0) System.out.println(a);
    }
}

interface MySum {
    int addition(int a, int b);
}

@FunctionalInterface
interface CalculateSqare {
    int square(int a);
}

interface StrFunction {
    String appendStr(String s);
}

class CalculateSqareImpl implements CalculateSqare {

    public int square(int a) {
        return a * a;
    }
}
