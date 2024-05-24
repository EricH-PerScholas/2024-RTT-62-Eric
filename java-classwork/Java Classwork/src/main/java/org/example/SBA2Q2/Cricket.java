package org.example.SBA2Q2;

import java.text.DecimalFormat;

public class Cricket implements Sport {

    private int[] playerIds;

    public Cricket() {
        playerIds = new int[12];

        for (int pos = 1; pos < playerIds.length; pos++) {
            playerIds[pos] = 1;
        }
        System.out.println("A new cricket team has been formed");
    }

    @Override
    public void calculateAvgAge(int[] age) {
        double sum = 0;
        for (int a : age) {
            sum = sum + a;
        }

        double average = sum / age.length;
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("The average age of the team is " + df.format(average));
    }

    @Override
    public void retirePlayer(int id) {
        if (playerIds[id] == -1) {
            System.out.println("Player has already retired");
        } else {
            playerIds[id] = -1;
            System.out.println("Player with id: " + id + " has retired");
        }
    }


    public static void main(String[] args) {
        Cricket c = new Cricket();

        int[] ages = {1, 5, 7};
        c.calculateAvgAge(ages);


        c.retirePlayer(3);
        c.retirePlayer(3);
    }

}
