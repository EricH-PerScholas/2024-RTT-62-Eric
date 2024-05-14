package org.example.Slides_303_11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapExamples {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();

        Map<String, String> stringMap = new HashMap<>();

        stringMap.put("key", "value");
        stringMap.put("key2", "value2");
        stringMap.put(null, "actual value");
        stringMap.put("null value", null);
        stringMap.put("null value 1", null);

        // this is adding null a 2nd time which will overwrite the existing value
        stringMap.put(null, "actual value 1234");

        // it will overwrite a non null key as well
        stringMap.put("key", "value 1234");

        for (String key : stringMap.keySet()) {
            String value = stringMap.get(key);
            System.out.println(key + " == " + value );
        }

        // in this case the key is an integer and the value is a string
        Map<Integer, String> intMap = new HashMap<>();
        intMap.put(10,"ten");

        // this happens sometimes, but usually there are other ways of solving problems
        // this would be a work around or a hack for allowing duplicate values for key
        // this takes a bit of extra work to implement but if you need this then you need it
        Map<String, List<String>> listMap = new HashMap<>();
        listMap.put("streets", new ArrayList<String>());
        listMap.get("streets").add("Street 1");
        listMap.get("streets").add("Street 2");

        listMap.put("avenues", new ArrayList<String>());

        // this happens when working with ad hoc queries
        // this is going happen far mroe often than the map of list
        // when it comes back from the database this way we just treat it as a read only object
        List<Map<String,Object>> queryResult;
    }

}
