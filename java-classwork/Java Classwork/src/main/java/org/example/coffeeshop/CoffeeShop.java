package org.example.coffeeshop;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CoffeeShop {

    private List<Product> products = new ArrayList<>();

    // building the menu of products for sale at the coffee shop
    public void initProducts() {
        ProductReader pr = new ProductReader();
        List<Product> productsFromFile = pr.readProducts();
        products.addAll(productsFromFile);

        Product p1 = new Product();
        p1.setPrice(5.46);
        p1.setName("Small Coffee");
        p1.setBeverage(true);
        products.add(p1);

        Product largeCoffee = new Product();
        largeCoffee.setPrice(9.46);
        largeCoffee.setName("Large Coffee");
        largeCoffee.setBeverage(true);
        products.add(largeCoffee);

        Product cakePop = new Product();
        cakePop.setPrice(4.89);
        cakePop.setName("Cake Pop");
        cakePop.setBeverage(false);
        products.add(cakePop);

        Product eggSandwich = new Product(7.89, "Egg Sandwich", false, 50);
        products.add(eggSandwich);

    }

    public void printCheapProducts() {
        // this code filters all products that are less than 5$
        List<Product> cheapProducts = products.stream().filter(product -> product.getPrice() < 5).collect(Collectors.toList());
        // this code prints each of the products that is less than 5$
        cheapProducts.forEach(product -> System.out.println(product.getName() + "\t" + product.getPrice()));

        // the same 2 lines of code written as a for loop
        for ( Product product : products ) {
            if ( product.getPrice() < 5 ) {
                System.out.println(product.getName() + "\t" + product.getPrice());
            }
        }
    }

    // print the list of products available for sale
    public void printProducts() {
        for ( int pos = 0 ; pos < products.size() ; pos++ ) {
            // getting the product from the array list by its position ... note that it is not using [] like an array
            Product product = products.get(pos);
            System.out.println((pos+1) + ") " + product.getName() + "\t" + product.getPrice() );
        }


        //products.forEach( (product) -> {System.out.println(product.getName() + "\t" + product.getPrice() );});
    }
}
