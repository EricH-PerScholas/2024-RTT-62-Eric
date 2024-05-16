package org.example.Slides_303_12;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionsExamples {

    private Scanner scanner = new Scanner(System.in);

    public int captureInput() {
        System.out.print("Enter an array position : ");
        int value = scanner.nextInt();
        return value;

    }


    public void run() {
        int[] array = new int[10];


        try {
            System.out.println("Before error");

            int pos = captureInput();
            // when the exception occurs on this line it will automatically jump to the catch block
            array[pos] = 5;

            // any code after the exception will not get run
            System.out.println("After Error - no error occurred");

            throw new Exception("This message should describe what went wrong");
        } catch (InputMismatchException ime) {
            try {
                // do some other code
            } catch (Exception ex1) {

            }
            System.out.println("The user entered bad data");
        } catch (ArrayIndexOutOfBoundsException aiobe) {
            System.out.println("The user entered an invalid array position " + aiobe.getMessage());
        } catch (Exception e) {
            System.out.println("Caught the exception e with message : " + e.getMessage());
            e.printStackTrace();
        } finally {
            // this code will execute no matter what
            System.out.println("Inside the finally block");
        }
    }


    public static void main(String[] args) {
        ExceptionsExamples ee = new ExceptionsExamples();
        ee.run();
    }
}
