package org.example.coffeeshop;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private CoffeeShop coffeeShop;

    public void printMenu() {
        System.out.println("0) Exit");
        System.out.println("1) Print the list of products");
        System.out.println("2) Order a product");

    }

    public void runCoffeeShop() {
        coffeeShop = new CoffeeShop();
        coffeeShop.initProducts();
        coffeeShop.printProducts();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.runCoffeeShop();
    }

}
