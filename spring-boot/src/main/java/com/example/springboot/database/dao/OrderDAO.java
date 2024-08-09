package com.example.springboot.database.dao;

import com.example.springboot.database.entity.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface OrderDAO extends JpaRepository<Order, Long> {

    // each Map is the list represents a row in the result set from the database
   // in this result, the String is the column name and the object is the value in the column
    // we are using native SQL so we need to give the flag in the Query annotation to be nativeQuery = true
    @Query(value="select o.id as order_id, o.order_date, od.quantity_ordered, p.product_name, p.id as product_id, " +
            "od.price_each " +
            "from orderdetails od, products p, orders o " +
            "where od.product_id = p.id and o.id = od.order_id and o.id = :orderId " +
            "order by order_id;", nativeQuery = true)
    List<Map<String,Object>> getOrderDetails(Integer orderId);


    @Query(value = " select * from orders where user_id = :userId and status = 'CART'", nativeQuery = true)
    Order findOrderInCartStatus(Integer userId);

}
