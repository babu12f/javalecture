package com.eshikhon;

public class Class9 {

    public static void main(String[] args) {
        int[] data = new int[5];
        data[0] = 4;
        data[1] = 40;
        data[2] = 56;
        data[3] = 65;
        data[5] = 19;

        int rs;
        for (int i = 0; i <data.length; i++) {
            if (data[i] == 56) {
                rs = i;
            }
        }

    }
}
