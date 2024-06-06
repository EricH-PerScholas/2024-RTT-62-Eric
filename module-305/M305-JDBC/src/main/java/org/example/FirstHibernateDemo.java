package org.example;

import org.example.database.dao.CustomerDAO;
import org.example.database.dao.EmployeeDAO;
import org.example.database.entity.Employee;

import java.util.List;

public class FirstHibernateDemo {

    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        CustomerDAO customerDAO = new CustomerDAO();

        // lets create a new employee in the database
//        Employee newEmployee = new Employee();
//
//        newEmployee.setFirstname("First NAME!!!");
//        newEmployee.setLastname("Lastname");
//        newEmployee.setEmail("rtt6211@perschols.org");
//        newEmployee.setOfficeId(3);
//        newEmployee.setExtension("X12345");
//        newEmployee.setJobTitle("Newbie");
//        newEmployee.setVacationHours(0);
//
//        employeeDAO.insert(newEmployee);

//        List<Employee> employees = employeeDAO.findByFirstName("First NAME!!!");
//        //List<Employee> employees = employeeDAO.findByLastName("Doe");
//
//        for ( Employee employee : employees ) {
//            System.out.println(employee);
//        }

        // this employee id exists in the database and will return a record
        Employee employee = employeeDAO.findById(1056);
        System.out.println(employee);

        // this employee id does not exist in the database and will return null
        // you know your query found a result if it is not null
        employee = employeeDAO.findById(1);
        System.out.println(employee);

    }

}
