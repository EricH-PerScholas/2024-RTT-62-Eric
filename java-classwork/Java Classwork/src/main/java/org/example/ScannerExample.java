package org.example;

import java.util.Scanner;

public class ScannerExample {


    public static void main(String[] args) {
        // this line instantiates the new scanner object allocates memory for it and gives a pointer to it in the sc1 variable
        Scanner sc1 = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num1 = sc1.nextInt();

        System.out.print("The number is : " + num1);

        sc1.close();
    }

}

