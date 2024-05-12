package org.example.Slides_303_11;

import org.example.Slides_303_9_Inheritance.Shape;

import java.util.*;

public class Examples<T> {

    public void setSomething(T variableName) {

    }

    public T getSomething() {
        return null;
    }


    public static void main(String[] args) {

        int[] ints = new int[5];
        for (int i : ints) {
            System.out.println(i);
        }

        Examples<String> e = new Examples();
        e.setSomething("String");

        Examples<Integer> e1 = new Examples();
        e1.setSomething(10);

        List<String> list = new LinkedList();
        list.add("abc");
        list.add("123");
        list.add(null);
        System.out.println("List size = " + list.size());

        list.add("abc");
        System.out.println("List size = " + list.size());
        for (String s : list) {
            System.out.println(s);
        }

        // ********** MAIN USE IS FOR DELETEING ELEMENTS FROM A LIST WHILE LOOOPING
        // primary use of an interator is to delete something from the list while looping over the list
        // VERY IMPORTANT - tryign to delete something from the list using a for loop will crash your program AND/OR produce
        // unexpected random results;
        Iterator<String> i = list.iterator();
        while (i.hasNext()) {
            String value = i.next();
            System.out.println(value);
            if (value.equals("abc")) {
                i.remove();
            }
        }



        Set<String> set = new HashSet<>();
        set.add("abc");
        set.add("123");
        set.add(null);

        System.out.println("Set size = " + set.size());

        set.add("abc");
        set.add(null);

        System.out.println("Set size = " + set.size());
        for (String s : set) {
            System.out.println(s);
        }


        Map<String, Integer> map = new HashMap<>();

    }

}
