package com.example.springboot.controller;

import com.example.springboot.database.dao.*;
import com.example.springboot.database.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private CustomerDAO customerDao;

    @Autowired
    private EmployeeDAO employeeDao;


    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam Integer employeeId) {
        ModelAndView response = new ModelAndView("employee/detail");

        List<Customer> customers = customerDao.findBySalesRepEmployeeId(employeeId);
        response.addObject("customers", customers);

        Employee employee = employeeDao.findById(employeeId);
        response.addObject("employee", employee);

        return response;
    }


}
