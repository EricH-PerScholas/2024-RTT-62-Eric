package org.example.Slides_303_4;

public class WhileLoopsExample {

    public static void main(String[] args) {

        int x = 1;

        while (true) {
            x = x + 1;
            System.out.println(x);
            if ( x == 10000) {
                break;
            }
        }

        do {
            x = x + 1;
        } while ( false);
    }
}
