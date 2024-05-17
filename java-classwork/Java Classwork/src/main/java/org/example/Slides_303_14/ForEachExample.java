package org.example.Slides_303_14;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ForEachExample {

    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();

        names.add("Larry");
        names.add("Steve");
        names.add("James");
        names.add("Jessica");
        names.add("Conan");
        names.add("Ellen");

        // printing all the names in the list
        names.forEach(a -> {
            System.out.println(a);
        });

        System.out.println("===================================================");

        // printing all names in the list with a new style for loop
        for (String a : names) {
            System.out.println(a);
        }

        System.out.println("===================================================");

        // using lambda to remove items from the list
        names = names.stream().filter(name -> !name.startsWith("E")).collect(Collectors.toList());

        // print the list after the items are removed
        for (String name : names) {
            System.out.println(name);
        }

        // count the number of names in the list start with J
        long count = names.stream().filter(name -> name.startsWith("J")).count();
        System.out.println("Names in list starting with J : " + count);



    }
}
