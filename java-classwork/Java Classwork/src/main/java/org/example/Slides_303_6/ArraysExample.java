package org.example.Slides_303_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysExample {

    public static void main(String[] args) {

        // can create variable and new array in line too
        // primitive numbers initialize to 0
        double[] dArray = new double[10];
        for (int pos = 0; pos < dArray.length; pos++) {
            System.out.println(pos + " -> " + dArray[pos]);
        }

        // can create an array for an object like string too
        // these will initialize to null because it is an object array
        // all object arrays init to null
        String[] sArray = new String[10];
        for (int pos = 0; pos < sArray.length; pos++) {
            System.out.println("-> " + sArray[pos]);
        }

        // this is also a valid way of creating a new array not that
        // it is on 2 lines.  First creates teh variable, 2nd creates the new array in memory
        int[] iArray;
        iArray = new int[20];

        // this gets used a bit from time to time
        // the compiler will see this and create an array of strings with size of 3 and puts the 3 values in the array
        String[] constants = {"String1", "String2", "String3"};
        // new style for loop can be used with arrays
        for (String constant : constants) {
            System.out.println(constant);
        }

        // this is the same as doing the above
        String[] c1 = new String[3];
        c1[0] = "String1";
        c1[1] = "String2";
        c1[2] = "String3";


        // this also works for other data types
        int[] intConstants = {1, 2, 3, 4, 5};
        for (int pos = 0; pos < intConstants.length; pos++) {
            System.out.println(intConstants[pos]);
        }

        // getting the length of an array is simply using .length
        int x = intConstants.length;

        String s = new String("New String");
        s.length(); // will give us the size of the string

        // this is 99% of what you will use in the future
        List<Double> dList = new ArrayList<>();
        dList.size();


        // descending
        int[] desc = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        Arrays.sort(desc);
        System.out.println(Arrays.toString(desc));


        // creating an object array
        Object[] objectArray = new Object[10];
        objectArray[0] = "String 1";
        objectArray[1] = 10;

        System.out.println(objectArray[-1]);

    }

}
