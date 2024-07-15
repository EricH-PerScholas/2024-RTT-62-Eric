package com.example.springboot.controller;

import com.example.springboot.database.dao.*;
import com.example.springboot.database.entity.*;
import com.example.springboot.form.*;
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

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView response = new ModelAndView("employee/create");

        return response;
    }

    // this is /employee/createSubmit
    @GetMapping("/createSubmit")
    public ModelAndView createSubmit(CreateEmployeeFormBean form) {
        ModelAndView response = new ModelAndView();

        // log out the incoming variables that are in the CreateEmployeeFormBean
        // variable name
        log.debug(form.toString());

        // setting the incoming user input onto a new Employee object to be saved to the database
        Employee employee = new Employee();
        employee.setEmail(form.getEmail());
        employee.setFirstname(form.getFirstName());
        employee.setLastname(form.getLastName());
        employee.setReportsTo(1002);
        employee.setExtension("x123");
        employee.setOfficeId(1);
        employee.setJobTitle("Job Title");


        // when we save to the data base it will auto increment to give us a new id
        // the new ID is available in the return from the save method.
        // basically returns the same object .. after its been inserted into the database
        employee = employeeDao.save(employee);

        // redirecting to the employee detail page
        // however often times this would redirect to the edit page (which we have not created)
        response.setViewName("redirect:/employee/detail?employeeId=" + employee.getId());

        return response;
    }
}
