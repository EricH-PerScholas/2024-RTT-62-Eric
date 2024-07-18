package com.example.springboot.validation;

import com.example.springboot.database.dao.*;
import com.example.springboot.database.entity.*;
import jakarta.validation.*;
import lombok.extern.slf4j.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.util.*;

public class EmployeeEmailUniqueImpl implements ConstraintValidator<EmployeeEmailUnique, String> {
    public static final Logger LOG = LoggerFactory.getLogger(EmployeeEmailUniqueImpl.class);

    @Autowired
    private EmployeeDAO employeeDao;


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // a test should only do one thing, so we should check for null first
        // always return true on null ... this is a pattern in creating test cases within JSR 303
        // its a good practice to always return true when your input value is null or empty
        if (StringUtils.isEmpty(value)) {
            return true;
        }

        //UserMSQL user = userService.findByEmailIgnoreCase(value);
        Employee employee = employeeDao.findByEmailIgnoreCase(value);

        // this validation returns true when the email is NOT in the database
        return (employee == null);
    }


}
