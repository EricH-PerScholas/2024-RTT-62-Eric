package com.example.springboot.database.dao;


import com.example.springboot.database.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeDAO extends JpaRepository<Employee, Long> {

    Employee findById(Integer id);


    // select * from employee where lower(email) = lower(:email)
    Employee findByEmailIgnoreCase(String email);

}
