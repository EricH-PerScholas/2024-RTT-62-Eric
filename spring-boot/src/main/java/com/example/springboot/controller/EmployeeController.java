package com.example.springboot.controller;

import com.example.springboot.database.dao.*;
import com.example.springboot.database.entity.*;
import com.example.springboot.form.*;
import jakarta.validation.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.*;
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

    @Autowired
    private OfficeDAO officeDao;


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
        // this method is setting up the view for rendering
        ModelAndView response = new ModelAndView("employee/create");

        // this list of employees is used in the Reports To dropdown to list all the employees
        List<Employee> reportsToEmployees = employeeDao.findAll();
        response.addObject("reportsToEmployees", reportsToEmployees);

        // add your office query to get all of the offices and add it to the model
        List<Office> offices = officeDao.findAll();
        response.addObject("offices", offices);


        return response;
    }

    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam(required = false) Integer employeeId) {
        // by setting required = false on the incoming parameter we allow null to enter the controller so that spring does not cause an error page
        // then we check if the input is null before trying to do our query

        // this view is the same for all the methods so far, even tho it is named create and we are using it for edit
        ModelAndView response = new ModelAndView("employee/create");

        // here again we have some duplicated code that could be refactored into a method
        List<Employee> reportsToEmployees = employeeDao.findAll();
        response.addObject("reportsToEmployees", reportsToEmployees);

        List<Office> offices = officeDao.findAll();
        response.addObject("offices", offices);

        // here I am checking the incoming employeeId to see if it is null or not
        if (employeeId != null) {
            // load the employee from the database and set the form bean with all the employee values
            // this is because the form bean is on the JSP page and we need to pre-populate the form with the employee data
            Employee employee = employeeDao.findById(employeeId);
            if (employee != null) {
                // we only do this code if we found an employee in the database
                CreateEmployeeFormBean form = new CreateEmployeeFormBean();

                // when we are doing an edit we need to pass the employee id to the JSP page so it can put it in the hidden input field
                form.setEmployeeId(employee.getId());

                form.setEmail(employee.getEmail());
                form.setFirstName(employee.getFirstname());
                form.setLastName(employee.getLastname());
                form.setReportsTo(employee.getReportsTo());
                form.setOfficeId(employee.getOffice().getId()); // interesteing hibernate here

                response.addObject("form", form);
            } else {
                // the employee was not found in the database
                response.addObject("errorMessage", "The employee was not found in the database.");
            }
        }

        return response;
    }

    // this is /employee/createSubmit
    // this method is only called when the form is submitted
    // this is being used for both edit and create because we are checking the incoming employeeid if it is null then it is a create
    @GetMapping("/createSubmit")
    public ModelAndView createSubmit(@Valid CreateEmployeeFormBean form, BindingResult bindingResult) {
        // arguement to the constructor here is the view name - the view name can be a JSP location or a redirect URL
        ModelAndView response = new ModelAndView();

        // we need to validate that the email does not exist in the database, however we only want to the check if this is a create
        // when doing a manual check in the controller we want this before the bindingResult.hasErrors() check so that it will fall into that block of code
        if ( form.getEmployeeId() == null ) {
            Employee e = employeeDao.findByEmailIgnoreCase(form.getEmail());
            // if the e is not null then it was found in the database which means the email is already in use
            if ( e != null ) {
                // this means the email already exists in the database
                bindingResult.rejectValue("email", "email", "This email is already in use. Manual Check");
            }
        }

        // the first thing we want to do is check if the incoming user input has any errors
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.debug("Validation error : " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
            }

            // TODO =  Cleanup this code to reduce the duplicated code in the create()

            // we are in this part of the if statement so we know for sure that an error has occured
            // we are going to add the binding result to the model, so we can use it on the JSP page to show the user the errors
            response.addObject("bindingResult", bindingResult);

            // because the page needs the list of employees for the drop down we need to add the list of employees to the model
            List<Employee> reportsToEmployees = employeeDao.findAll();
            response.addObject("reportsToEmployees", reportsToEmployees);

            // we need the list of offices
            List<Office> offices = officeDao.findAll();
            response.addObject("offices", offices);

            // im going to set the view name to be
            response.setViewName("employee/create");

            // im going to add the form to the model so that we can display the user entered data in the form
            response.addObject("form", form);

            return response;
        } else {

            // log out the incoming variables that are in the CreateEmployeeFormBean
            // variable name
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

            // redirecting to the employee detail page
            // however often times this would redirect to the edit page (which we have not created)
            // after the redirect is actually a URL not a view name
            // in some ways this is overriding the behavior of the setViewName to use a URL rather than a JSP file location
            response.setViewName("redirect:/employee/detail?employeeId=" + employee.getId());

            return response;
        }
    }
}
