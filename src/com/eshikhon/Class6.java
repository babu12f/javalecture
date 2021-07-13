package com.eshikhon;

import java.util.Scanner;

public class Class6 {

    public static void main(String[] args) {
        int[][] data = {{1, 2, 3},
                        {4, 5, 6}};

        for (int d[] : data) { //dada[0] = [1,2,3]
            for (int v : d) {
                System.out.println(v);
            }
        }

    }

}
