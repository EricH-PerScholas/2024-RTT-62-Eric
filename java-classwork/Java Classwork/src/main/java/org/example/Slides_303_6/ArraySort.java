package org.example.Slides_303_6;

import java.util.Arrays;

public class ArraySort {

    public static void main(String[] args) {

        // algorithm found at https://www.geeksforgeeks.org/bubble-sort/
        int[] array = {1, 3, 2, 4, 5, 0};

        for (int outer = 0; outer < array.length - 1; outer++) {
            boolean swapped = false;
            for (int pos = 0; pos < array.length - 1; pos++) {
                if (array[pos] > array[pos + 1]) {
                    int temp = array[pos];
                    array[pos] = array[pos + 1];
                    array[pos + 1] = temp;
                    swapped = true;
                }
            }
            System.out.println("outer = " + outer + " -> " + Arrays.toString(array));

            if (swapped == false) {
                break;
            }
        }
    }

}
