package org.example;

import org.example.database.dao.EmployeeDAO;
import org.example.database.entity.Employee;

import java.util.List;

public class FirstHibernateDemo {

    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();

        //List<Employee> employees = employeeDAO.findByFirstName("Leslie");
        List<Employee> employees = employeeDAO.findByLastName("Doe");

        for ( Employee employee : employees ) {
            System.out.println(employee.getId() + " | " + employee.getFirstname() + " " + employee.getLastname() + " | "
                    + employee.getEmail() + " | " + employee.getJobTitle());
        }


    }

}
