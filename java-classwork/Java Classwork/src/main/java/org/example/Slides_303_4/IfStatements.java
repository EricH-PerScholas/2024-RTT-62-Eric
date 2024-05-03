package org.example.Slides_303_4;

import org.example.ScannerExample;

import java.util.Scanner;

public class IfStatements {

    public static void main(String[] args) {

        //Scanner scanner = new Scanner(System.in);
        //int x = scanner.nextInt();
        int x = 99;
        x = test(x);

        if (x < 10) {
            System.out.println("Less than 10 " + (x < 10));
            // any number of lines of code in here
        } else if (x < 20) {
            System.out.println("Less than 20 ");
        } else if (x < 30) {
            System.out.println("Less than 30 ");
        } else {
            System.out.println("Greater than 30 ");
        }

        // note how these will all execute because there is no else

        if (x < 10) {
            System.out.println("Less than 10 ");
        }

        if (x < 20) {
            System.out.println("Less than 20 ");
        }

        if (x < 30) {
            System.out.println("Less than 30 ");
        } else {
            System.out.println("Greater than 30 ");
        }

        int i = 3;
        int j = 2;
        int k = 1;

        if (i > j) {
            if (i > k)
                System.out.println("A");

            System.out.println("always print this");
        } else {
            System.out.println("B");
        }


    }

    public static int test(int x) {
        x = x + 1;
        return x;
    }

}
