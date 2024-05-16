package org.example.Slides_303_13;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileReaderExample {

    public static void main(String[] args) throws Exception {

        File input = new File("output.txt");
        FileReader reader = new FileReader(input);
        BufferedReader br = new BufferedReader(reader);

        String line = br.readLine();
        while ( line != null ) {
            System.out.println(line);
            line = br.readLine();
        }
    }
}
