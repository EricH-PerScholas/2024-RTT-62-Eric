package org.example.SBA2Q1;

import java.util.ArrayList;

public class ArrayToList {

    private ArrayList<String> arrayToList = new ArrayList<>();

    public ArrayToList() {
        arrayToList = new ArrayList<>();
    }

    public void convert(String[] a) {
        for ( int pos = 0 ; pos < a.length ; pos++ ) {
            // add will always add to the last spot in the list
            arrayToList.add(a[pos]);
            System.out.println("I have added the string: " + a[pos] + " at the index: " + pos);
        }
    }

    public void replace(int idx) {
        // what we are doing here is getting the actual string that is in the
        // arrayToList before we over write it in the next line of code
        String value = arrayToList.get(idx);

        // this is not valid for a list only for an array
        //arrayToList[idx] = "";

        // this is how you do it with an array list
        // set function takes 2 args .. first is the position to set
        // the second is the value to set
        arrayToList.set(idx,"");

        System.out.println("I have replaced the string: " + value + " with a null string");

        // this is just extra for the difference between empty string and null
        String x = "";  // this is the empty string
        String y = null;  // this means there is no string set in memory.
    }

    public ArrayList<String> compact() {
        ArrayList<String> result = new ArrayList<>();

        for (String s : arrayToList ) {
            if ( ! s.equals("")) {
                // make sure you are adding it to the result
                result.add(s);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayToList arrayToList = new ArrayToList();

        String[] strArray = {"one", "two", "three", "four", "five" };
        arrayToList.convert(strArray);

        arrayToList.replace(1);
        arrayToList.replace(2);

        ArrayList<String> compacted = arrayToList.compact();
        for( String c : compacted ) {
            System.out.println(c);
        }
    }

}
