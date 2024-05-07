package org.example.Slides_303_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayInsertFunction {

    public static int[] insert(int[] source, int insertPosition, int valueToInsert) {
        // lets write some code to insert a 9 into the array at position 2
        // 1) create a new array of size + 1
        int[] result = new int[source.length + 1];

        // 2) copy the first part of the array (before position 2) from the old to the new
        for (int pos = 0; pos < insertPosition; pos++) {
            result[pos] = source[pos];
        }

        // 3) actually insert the value we want in position 2
        result[insertPosition] = valueToInsert;

        // 4) copy over the rest of the array
        for (int pos = insertPosition; pos < source.length; pos++) {
            result[pos + 1] = source[pos];
        }

        return result;
    }

    // original implementation inserted a 9 at position 2
    public static void main(String[] args) {

        // original array
        // pos   01234
        // value 12345

        int[] array = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(array));

        // array after inserting
        // pos   012345
        // value 129345

        // inserting 9 at position 2
        array = insert(array,2, 9);
        System.out.println(Arrays.toString(array));

        // inserting 0 at position 0
        array = insert(array,0, 0);
        System.out.println(Arrays.toString(array));
    }


}
