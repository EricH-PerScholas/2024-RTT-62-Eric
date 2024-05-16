package org.example.Slides_303_13;

import java.io.File;
import java.io.IOException;

public class FileExample {

    public static void main(String[] args) {

        // .. means go up one directory from where you are
        // .  mean the current directory where I am right now.
        try {
            File f = new File(".");
            System.out.println(f.getCanonicalPath());

            File[] files = f.listFiles();
            for (File file : files) {
                System.out.print("     " + file.getCanonicalPath());
                if (file.isDirectory()) {
                    System.out.println(" is a directory");
                } else {
                    System.out.println(" is a file");
                }
            }


            File file = new File(".\\newfile.txt");
            file.createNewFile();

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }


        File code = new File("C:\\Users\\eric\\development\\2024-RTT-62\\java-classwork\\Java Classwork\\src\\main\\java\\org\\example\\Slides_303_13\\FileExample.java");

        File relative = new File("..\\..\\New Folder\\newfile.txt");

        File mac = new File("/home/user/development/2024-RTT-62/java-classwork");

    }
}
