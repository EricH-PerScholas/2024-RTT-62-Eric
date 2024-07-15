package com.example.springboot.database.dao;

import com.example.springboot.database.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CustomerDAO extends JpaRepository<Customer, Long> {

    Customer findById(Integer id);

    List<Customer> findBySalesRepEmployeeId(Integer id);
}
