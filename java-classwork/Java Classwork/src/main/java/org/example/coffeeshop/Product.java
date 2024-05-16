package org.example.coffeeshop;

public class Product {

    private double price;
    private String name;
    private boolean beverage;
    private int quantityAvailable;



    // constructor with no args - by default this is included with the java language
    public Product() {
        System.out.println("No args constructor called");
    }

    // constructor with all args
    // it is only if you want to have a custom constructor that you add it
    public Product(double price, String name, boolean beverage, int quantityAvailable) {
        this.price = price;
        this.name = name;
        this.beverage = beverage;
        this.quantityAvailable = quantityAvailable;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBeverage() {
        return beverage;
    }

    public void setBeverage(boolean beverage) {
        this.beverage = beverage;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", beverage=" + beverage +
                ", quantityAvailable=" + quantityAvailable +
                '}';
    }
}
