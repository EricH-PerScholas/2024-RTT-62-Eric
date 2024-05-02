package org.example;

import java.text.DecimalFormat;

public class Homework303_2_1 {

    static final double SALES_TAX = 0.09;


    public static void main(String[] args) {

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

        double div = (double) v1 / (double) v2;
        System.out.println(div);


        Integer abc = null;
        abc = 150;

        double abcd = abc.doubleValue();


        // Write a program where you create three variables that represent products at a cafe. The products could be beverages like coffee,
        // cappuccino, espresso, green tea, etc. Assign prices to each product. Create two more variables called subtotal and totalSale and
        // complete an “order” for three items of the first product, four items of the second product, and two items of the third product.
        // Add them all together to calculate the subtotal. Create a constant called SALES_TAX and add sales tax to the subtotal to obtain
        // the totalSale amount. Be sure to format the results to two decimal places.

        double coffee = 2.50;
        coffee = 2.55;

        double cappuccino = 3.50;
        double espresso = 4.50;

        double subtotal = (coffee * 3) + (cappuccino * 4) + (espresso * 2);

        double salesTaxAmount = subtotal * SALES_TAX;
        double totalAmount = subtotal + salesTaxAmount;

        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Subtotal   : " + df.format(subtotal));
        System.out.println("Sales Tax  : " + df.format(salesTaxAmount));
        System.out.println("Total Sale : " + df.format(totalAmount));


    }
}
