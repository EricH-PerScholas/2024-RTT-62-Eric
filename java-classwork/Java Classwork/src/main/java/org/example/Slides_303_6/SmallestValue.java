package org.example.Slides_303_6;

public class SmallestValue {

    public static void main(String[] args) {
        int[] myarray = {199, 198, 201, 0, 2, 4, 6, 8, 10};

        int minVal = myarray[0];
        
        for (int i = 0; i < myarray.length; i++) {
            int value = myarray[i];
            if (value < minVal) {
                minVal = myarray[i];
            }
        }

        System.out.println("minVal = " + minVal);
    }

}
