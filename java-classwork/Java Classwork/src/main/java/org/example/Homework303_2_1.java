package org.example;

public class Homework303_2_1 {

    public static void main(String[] args){

        // Write a program that declares two integer variables, assigns an integer to each, and adds them together.
        // Assign the sum to a variable. Print out the result.
        int num1 = 10;
        int num2 = 20;

        int sum = num1 + num2;

        System.out.println("The sum of " + num1 + " and " + num2 + " is " + sum);

        // Write a program that declares two double variables, assigns a number to each, and adds them together.
        // Assign the sum to a variable. Print out the result.
        double d1 = 10.5d;
        double d2 = 20.5f;

        double dSum = d1 + d2;
        System.out.println(dSum);

        //Write a program that declares an integer variable and a double variable, assigns numbers to each, and adds them together.
        // Assign the sum to a variable. Print out the result. What variable type must the sum be?
        int x = 30;
        double y = 50.55;

        double sum3 = x + y;
        System.out.println(sum3);

        //Write a program that declares two integer variables, assigns an integer to each, and divides the larger number by the smaller number.
        // Assign the result to a variable. Print out the result. Now change the larger number to a decimal.
        // What happens? What corrections are needed?
        int v1 = 5;
        int v2 = 2;

        double div = (double)v1 / (double)v2;
        System.out.println(div);
    }
}
