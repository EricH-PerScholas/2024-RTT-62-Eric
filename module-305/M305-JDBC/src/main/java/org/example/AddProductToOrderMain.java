package org.example;

import org.example.database.dao.OrderDAO;
import org.example.database.dao.OrderDetailDAO;
import org.example.database.dao.ProductDAO;
import org.example.database.entity.Order;
import org.example.database.entity.OrderDetail;
import org.example.database.entity.Product;

public class AddProductToOrderMain {

    // I want to be able to add a product to an order with the quantity 100

    // 1) Load an order from the database by id
    // 2) Load a product from the database by id
    // 3) Create a new OrderDetail object and add the order and the product
    // 4) Save the OrderDetail object to the database

    private OrderDAO orderDAO = new OrderDAO();
    private ProductDAO productDAO = new ProductDAO();
    private OrderDetailDAO orderDetailDAO = new OrderDetailDAO();

    public void run() {
        // read the order from the database
        Order order = orderDAO.findById(10100);
        System.out.println(order);
        System.out.println("This order is for customer with an id = " + order.getCustomer().getId() + " and name = " + order.getCustomer().getCustomerName());
        
        // read the product from the database
        Product product = productDAO.findById(77);
        System.out.println(product);

        // setup the order details object with the values I want to save to the database
        OrderDetail orderDetail = new OrderDetail();

        // we can just set the product and order objects we just queried on the order detail
        orderDetail.setProduct(product);
        orderDetail.setOrder(order);
        orderDetail.setQuantityOrdered(100);
        orderDetail.setPriceEach(product.getMsrp());
        orderDetail.setOrderLineNumber(10);

        // save the order details to the database
        orderDetailDAO.insert(orderDetail);
    }


    public static void main( String[] args ) {
        AddProductToOrderMain apto = new AddProductToOrderMain();
        apto.run();
    }

}
