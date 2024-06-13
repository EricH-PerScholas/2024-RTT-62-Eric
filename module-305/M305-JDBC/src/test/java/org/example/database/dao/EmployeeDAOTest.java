package org.example.database.dao;

import org.example.database.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class EmployeeDAOTest {

    private EmployeeDAO employeeDAO = new EmployeeDAO();

    @ParameterizedTest
    @CsvSource(
            {
                    "Leslie",
                    "Tom",
            }
    )
    public void findByFirstNameTest(String firstName) {
        // given

        // when
        List<Employee> employees = employeeDAO.findByFirstName(firstName);

        // then
        Assertions.assertTrue(employees.size() > 0);
        for (Employee e : employees) {
            Assertions.assertEquals(firstName, e.getFirstname());
        }
    }

    @Test
    public void createEmployeeTest() {
        Employee given = new Employee();

        given.setFirstname("Test Employee");
        given.setLastname("Lastname");
        given.setJobTitle("Job Title");
        given.setEmail("employee@employee.com");
        given.setOfficeId(1);
        given.setExtension("24");
        given.setReportsTo(1088);
        given.setVacationHours(10);
        given.setProfileImageUrl("http://example.com/profile/testemployee");

        employeeDAO.insert(given);
        // right here .. given is going to have an id
        // hibernate will create the new PK id value and set it on the given object as part of the save

        Employee actual = employeeDAO.findById(given.getId());

        Assertions.assertEquals(given.getFirstname(),actual.getFirstname());
        Assertions.assertEquals(given.getLastname(), actual.getLastname());
        // ... add all the rest of the assertions here to validate the object is the same

        // now lets delete the record from the database
        employeeDAO.delete(given);

        // we could do even one more after this to verify that it is indeed gone
        Employee delete = employeeDAO.findById(given.getId());
        Assertions.assertNull(delete);
    }
}
