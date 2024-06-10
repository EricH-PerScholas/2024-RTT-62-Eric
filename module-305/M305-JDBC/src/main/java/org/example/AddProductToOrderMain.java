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

    // if the product is already part of the order then increment the quantity ordered
    // 1) In your orderdetail dao .. create a findByProductIdAndOrderId method, also create insert and update methods
    // 2) instead of just createing a new order detail run your new query
    // 3) check if the order detail returned is null and if so create a new order detail
    // 4) check if the quantity orderd == null if so set to 1 otherwise increment by 1
    // 5) when saving ... check if the orderdetail.getid == null .. if so then it is an insert otherwise it is an update


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
        Product product = productDAO.findById(11);
        System.out.println(product);

        // setup the order details object with the values I want to save to the database
        // if this query returns a order detail then it means this product is already part of the order
        OrderDetail orderDetail = orderDetailDAO.findByOrderIdAndProductId(order.getId(), product.getId());
        if ( orderDetail == null ) {
            // this means the product was not found in the database as part of the order
            // this will be an insert of a new product
            orderDetail = new OrderDetail();
        }

        // we want to increase the quantity ordered
        // if this is a new orderdetail the existing quantity ordered will be 0
        // if this is an existing orderdetail the quantity ordered will already be set
        // in either case I want to increase the quantity ordered by 1
        if ( orderDetail.getQuantityOrdered() == null) {
            // this is a new product being added to the order
            orderDetail.setQuantityOrdered(1);
        } else {
            // this is an exciting product in the order where we are incrementing the quantity ordered.
            orderDetail.setQuantityOrdered(orderDetail.getQuantityOrdered() + 1);
        }

        // we can just set the product and order objects we just queried on the order detail
        orderDetail.setProduct(product);
        orderDetail.setOrder(order);
        orderDetail.setPriceEach(product.getMsrp());
        orderDetail.setOrderLineNumber(10);

        // save the order details to the database
        // it is important to know ... if the id is null then you need to insert it
        // if the record was found in the database then the id will be not null so that is how we know it is an update rather than an insert
        if ( orderDetail.getId() == null ) {
            // hibernate will automatically populate the id as part of the insert and it will be the new id generated by the auto increment
            orderDetailDAO.insert(orderDetail);
        } else {
            orderDetailDAO.update(orderDetail);
        }
    }


    public static void main( String[] args ) {
        AddProductToOrderMain apto = new AddProductToOrderMain();
        apto.run();
    }

}
