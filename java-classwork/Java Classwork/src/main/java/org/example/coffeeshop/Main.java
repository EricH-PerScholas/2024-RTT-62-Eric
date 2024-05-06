package org.example.coffeeshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private CoffeeShop coffeeShop;
    private Scanner scanner = new Scanner(System.in);

    public void printMenu() {
        System.out.println("0) Exit");
        System.out.println("1) Print the list of products");
        System.out.println("2) Order a product");
        System.out.println("3) Checkout");
    }

    public void runCoffeeShop() {
        coffeeShop = new CoffeeShop();
        coffeeShop.initProducts();
        coffeeShop.printProducts();
    }

    // we only have 1 public static void main for the whole coffee shop project
    // this will be the way the program starts up
    public static void main(String[] args) {
        Main main = new Main();
        main.runCoffeeShop();
    }

}
