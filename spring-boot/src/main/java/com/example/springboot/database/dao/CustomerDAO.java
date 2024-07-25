package com.example.springboot.database.dao;

import com.example.springboot.database.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

import java.util.List;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Long> {

    Customer findById(Integer id);

    List<Customer> findBySalesRepEmployeeId(Integer id);

    int countBySalesRepEmployeeId(Integer id);

    boolean existsBySalesRepEmployeeId(Integer id);
}
