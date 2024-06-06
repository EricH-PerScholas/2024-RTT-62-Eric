package org.example;

import org.example.database.dao.ProductDAO;
import org.example.database.entity.Product;

import java.util.List;
import java.util.Scanner;

public class ProductMain {

    // I Want to be able to search for a product and then change the quantity in stock to reflect current inventory levels.
    // 1) I need to be able to prompt the user for which product to search for
    // 2) I need to be able to show the products and allow the user to select a product to modify
    // 2.5) Use the id of the product the user just entered to do a query on the database
    // 3) I need to prompt the user to enter the new value quantity in stock
    // 4) I need to set the new quantity in stock on the product and save it to the database

    private ProductDAO productDAO = new ProductDAO();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        // prompt the user to enter a product name
        String productName = inputProductSearch();

        // use our productDAO to run the query
        List<Product> products = productDAO.findLikeName(productName);

        // #2 print the list of products
        int productId = printProductsAndPromptForProductId(products);

        // #2.5
        Product selected = productDAO.findById(productId);
        System.out.println(selected);

        // #3
        int quantity = promptQuantityInStock();
        System.out.println(quantity);
    }

    public int promptQuantityInStock() {
        System.out.println("Enter the new value for quantity in stock: ");
        int quantity = scanner.nextInt();
        return quantity;
    }

    public int printProductsAndPromptForProductId(List<Product> products) {
        // print out the results of the query
        System.out.println("Id | Product Name | Quantity In Stock");
        System.out.println("=========================================================");
        for ( Product product: products ) {
            System.out.println(product.getId() + " | " + product.getProductName() + " | " + product.getQuantityInStock());
        }

        System.out.print("\nEnter the product id to modify: ");
        int id = scanner.nextInt();

        return id;
    }

    public String inputProductSearch() {
        System.out.print("Enter a product name to search for: ");
        String productName = scanner.nextLine();
        return productName;
    }

    public static void main(String[] args) {
        ProductMain pm = new ProductMain();
        pm.run();
    }
}
