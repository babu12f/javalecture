package com.assignmentcheck;

import java.util.Scanner;


public class Assigmnent {

    public static <number1> void main(String[] args) {

        char operator;
        double number1,number2;

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the Operator ( +, -, *, /)");
        operator = input.next().charAt(0);

        System.out.println("Enter the two numbers with a space in between");
        number1 = input.nextDouble();
        number2 = input.nextDouble();

        input.close();

        switch ( operator ) {
            case '+' :
                System.out.println(  number1 + "+" +  number2 +  "= " + ( number1 + number2 ) ) ;
                break;

            case '-' :
                System.out.println (number1 + "-" +  number2 +  "= " + ( number1 - number2 ) ) ;
                break;

            case '*' :
                System.out.println(number1 + "*" +  number2 +  "= " + ( number1 * number2 ) ) ;
                break;

            case '/' :
                System.out.println( number1 + "/" +  number2 +  "= " + ( number1 / number2 ) ) ;
                break;

            default:
                System.out.println("Invalid operator");
        }

    }
}