package org.example;

public class KBA1Review {


    public KBA1Review() {

    }

    private Integer x;

    public static void main(String[] args) {

        // these are valid ways of creating an array
        // know how to make an array
        int[] arr = new int[12];
        int[] arr1; arr1 = new int[12];

        // static keyword implies that the class members (static ones) belong to the class, not to the instance.

        // what is autoboxing?

        // what is the difference between String and StringBuffer - string is not mutable and stringbuffer is

        // IS-A relationship in java ... for example a Rectangle IS A Shape

        // Truncation is chopping the decimal value off when casting to an interger type

        // know the difference between a local variable and class variable - local variables are only scoped to the code block they are in
        // class variables are available to all methods in the class.

        // know what the definition of method overloading is

        // return type of constructor - there is none

        // protected is - subclasses in other packages OR any class within the same package

        // know the difference between ++y and y++

        // know what % (mod) - gives us the remainder of the division

        // know what continue and break do
        //  continue - will skip any code after and go to the top of the loop for the next iteration
        //  break - exit loop immediately and do not execuite any code after the break that is inside the loop

        String a = "AFTER";
        String b = "BETA";
        String c = "CAPTURE";

        // these 2 functions are not the same
        printOutput(a + b + c);
        printOutput(a,b,c);

        // know how to create a new object
        Object o = new Object();
        String s = new String();

        // the fields/variable in an interface must be static and final - meaning they can not be changed.  They
        // are simply read only constants

        // public static void main(String[] args) - be able to pick something wrong

        // when defining a boolean the true and false are keywords and must be lowercase
        boolean bt = true;
        boolean bf = false;

        // java does not support multiple inheritance
        // you can not craete a new instance an interface.
    }


    public static void printOutput(String output) {
        System.out.println(output.toLowerCase());
    }

    public static void printOutput(String a, String b, String c) {
        System.out.println(a + b + c);
    }
}
