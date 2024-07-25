package com.example.springboot.service;

import com.example.springboot.database.dao.*;
import com.example.springboot.database.entity.*;
import com.example.springboot.form.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Slf4j
@Component
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDao;

    @Autowired
    private OfficeDAO officeDao;


    public Employee createEmployee(CreateEmployeeFormBean form) {
        // log out the incoming variables that are in the CreateEmployeeFormBean
        log.debug(form.toString());

        // first, I am going to take a shot at looking up the record in the database based on the incoming employeeId
        // this is from the hidden input field and is not something the user actually entered themselves
        Employee employee = employeeDao.findById(form.getEmployeeId());
        if ( employee == null ) {
            /// this means it was not found in the database so we are going to consider this a create
            employee = new Employee();
        }

        // here we are setting the values from the inoming form data onto the database entity
        employee.setEmail(form.getEmail());
        employee.setFirstname(form.getFirstName());
        employee.setLastname(form.getLastName());
        employee.setReportsTo(form.getReportsTo());
        employee.setExtension("x123");
        employee.setJobTitle("Job Title");

        Office office = officeDao.findById(form.getOfficeId());
        // this wont work because its set to insertable = false and updateable = false
        //employee.setOfficeId(1);
        employee.setOffice(office);

        // when we save to the data base it will auto increment to give us a new id
        // the new ID is available in the return from the save method.
        // basically returns the same object .. after its been inserted into the database
        employee = employeeDao.save(employee);

        return employee;
    }
}
