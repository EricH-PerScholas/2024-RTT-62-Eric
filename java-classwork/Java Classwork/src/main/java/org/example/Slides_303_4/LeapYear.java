package org.example.Slides_303_4;

import java.util.Scanner;

public class LeapYear {

    public static void main(String[] args) {
        // This program first prompts the user to enter a year as an int, and checks if it is a leap year.
        // A year is a leap year if it is divisible by 4 but not by 100, or it is divisible by 400.

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a year : ");
        int year = scanner.nextInt();

        if ((year % 4 == 0) && (year % 100 > 0)) {
            System.out.println(year + " is a leap year ");
        } else if (year % 400 == 0) {
            System.out.println(year + " is a leap year ");
        } else {
            System.out.println(year + " is NOT a leap year ");
        }
    }
}
