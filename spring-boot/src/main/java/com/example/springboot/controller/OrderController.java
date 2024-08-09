package com.example.springboot.controller;

import com.example.springboot.database.dao.OrderDAO;
import com.example.springboot.database.dao.OrderDetailsDAO;
import com.example.springboot.database.dao.ProductDAO;
import com.example.springboot.database.entity.Order;
import com.example.springboot.database.entity.OrderDetail;
import com.example.springboot.database.entity.Product;
import com.example.springboot.database.entity.User;
import com.example.springboot.security.AuthenticatedUserUtilities;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class OrderController {

    @Autowired
    private OrderDAO orderDao;

    @Autowired
    private OrderDetailsDAO orderDetailsDao;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private AuthenticatedUserUtilities authenticatedUserUtilities;

    @GetMapping("/order/orderdetail")
    public ModelAndView orderDetail(@RequestParam Integer orderId) {
        ModelAndView response = new ModelAndView("order/orderdetail");

        List<Map<String,Object>> orderDetails = orderDao.getOrderDetails(orderId);
        response.addObject("orderDetails", orderDetails);

        return response;
    }

    @GetMapping("/order/addToCart")
    public ModelAndView addToCart(@RequestParam Integer productId) {
        ModelAndView response = new ModelAndView();

        // first we can look up the product in the database given the incoming productId
        Product product = productDAO.findById(productId);

        // get the logged in user
        User user = authenticatedUserUtilities.getCurrentUser();

        // now we need to get the order from the database where the status is 'CART' and the user is the logged in user
        Order order = orderDao.findOrderInCartStatus(user.getId());
        if ( order == null ) {
            // the user does not have an order in cart status so we need to create one
            order = new Order();
            order.setUser(user);
            order.setOrderDate(new Date());
            order.setStatus("CART");

            // dont need this in your case study
            order.setCustomerId(103);
            order.setRequiredDate(new Date());

            orderDao.save(order);
        }

        // now we have to look to see if the product is already in the order details table
        OrderDetail orderDetail = orderDetailsDao.isProductInCart(order.getId(), productId);
        if ( orderDetail == null ) {
            // this product is not part of this order so we can create a new orderdetails
            orderDetail = new OrderDetail();
            orderDetail.setOrder(order);
            orderDetail.setProduct(product);
            orderDetail.setQuantityOrdered(1);

            orderDetailsDao.save(orderDetail);
        } else {
            // the product is already in the cart so we need to increment the quantity
            orderDetail.setQuantityOrdered(orderDetail.getQuantityOrdered() + 1);
            orderDetailsDao.save(orderDetail);
        }

        return response;
    }

}
