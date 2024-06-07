package org.example;

import org.example.database.dao.CustomerDAO;
import org.example.database.dao.OrderDAO;
import org.example.database.dao.OrderDetailDAO;
import org.example.database.dao.ProductDAO;
import org.example.database.entity.Customer;
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
    private CustomerDAO customerDAO = new CustomerDAO();

    public void run() {
        // read the order from the database
        Order order = orderDAO.findById(10100);
        System.out.println(order);

        // this line of code will actually make hibernate do the query to get the customer entity and its going to use
        // the annotations and the FK value from inside the order object to create and execute the query on our behalf without us doing anything.
        // these 2 lines of code do the same thing.   First line hibernate does the work for you
        // the second line of code (commented) actually does the exact same thing accept manually doing the query with the FK id
        Customer customer = order.getCustomer();
        //Customer customer = customerDAO.findById(order.getCustomerId());

        System.out.println("This order is for customer with an id = " + customer.getId() + " and name = " + customer.getCustomerName());

        // NOTE - this way of looping over the products is very inefficient on the database because it runs allot of queries
        // this same thing could be accomplished with a single custom query that returns columns from multiple different tables
        // lets print out the products that are part of this order already
        // this next line of code executes a query to get the order details .. basically its doing the equivalent of
        // orderDetailsDAO.findByOrderId(order.getId());
        for ( OrderDetail od : order.getOrderDetails() ) {
            // the next line of code is going cause hibernate to query the product table
            // essentially doing productDAO.findById(od.getProductId());
            System.out.println(od.getProduct().getProductName() + " | " + od.getQuantityOrdered() + " | " + od.getPriceEach());
        }

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
