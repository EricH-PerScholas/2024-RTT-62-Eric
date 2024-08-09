package com.example.springboot.database.dao;

import com.example.springboot.database.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderDetailsDAO extends JpaRepository<OrderDetail, Long> {


    @Query(value = "select * from orderdetails where order_id = :orderId and product_id = :productId", nativeQuery = true)
    OrderDetail isProductInCart(Integer orderId, Integer productId);
}
