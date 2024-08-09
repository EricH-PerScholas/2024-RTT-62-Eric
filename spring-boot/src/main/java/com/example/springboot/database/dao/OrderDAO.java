package com.example.springboot.database.dao;

import com.example.springboot.database.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface OrderDAO extends JpaRepository<Order, Long> {

    // TODO : make this query work for your data model you need all of the columns in the query
    @Query(value="select o.id as order_id, o.order_date, od.quantity_ordered as quantity, p.product_name, p.id as product_id, p.buy_price as price, " +
            " (od.quantity_ordered * p.buy_price) as total " +
            "from orderdetails od, products p, orders o " +
            "where od.product_id = p.id and o.id = od.order_id and o.id = :orderId ", nativeQuery = true)
    List<Map<String,Object>> getOrderDetails(Integer orderId);


    // this is a query that will get the total order amount for a given order
    // TODO : make this query work for your data model
    @Query(value = "select sum(od.quantity_ordered * p.buy_price) as orderTotal " +
            "from orderdetails od, products p, orders o " +
            "            where od.product_id = p.id and o.id = od.order_id and o.id = :orderId ", nativeQuery = true)
    Double getOrderTotal(Integer orderId);


    @Query(value = " select * from orders where user_id = :userId and status = 'CART'", nativeQuery = true)
    Order findOrderInCartStatus(Integer userId);

}
