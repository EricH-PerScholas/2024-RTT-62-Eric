package org.example.Slides_303_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ForLoopExample {

    public static void main(String[] args) {

        // this is an old school for loop
        for (int count = 10; count > 0; count--) {
            if (count % 2 == 0) {
                System.out.println("This is an even number");

                for (int d = 0; d < 5; d++) {
                    System.out.println("The count = " + count + "." + d);
                }
            }
        }

        List<String> stringList = new ArrayList<>();
        stringList.add("First Element");  // position 0
        stringList.add("Two");  // position 1
        stringList.add("Three");
        stringList.add("Four"); // pos 3
        stringList.add("5"); // pos 4

        // we can use an old style for loop to move across this list
        for (int pos = 0; pos < stringList.size(); pos++) {
            System.out.println(stringList.get(pos));
        }

        // we can use an old style for loop to move across this list
        for (int pos = stringList.size() - 1; pos >= 0; pos--) {
            System.out.println(stringList.get(pos));
        }

        System.out.println("----------------------------------");

        // nice new for loop
        int count = 0;
        for (String element : stringList) {
            if ( element.equals("Three")) {
                break;
            }
            System.out.println(element);
            count++;
        }

    }
}
