package org.example.database.dao;

import jakarta.persistence.TypedQuery;
import org.example.database.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class EmployeeDAO {


    public void insert(Employee employee) {
        // these 2 lines of code prepare the hibernate session for use
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        // begin the transaction
        session.getTransaction().begin();

        // insert the employee to the database
        session.save(employee);

        /// commit our transaction
        session.getTransaction().commit();

        // cleanup the session
        session.close();
    }

    public void update(Employee employee) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.getTransaction().begin();

        // this is the only line that changed
        session.merge(employee);

        session.getTransaction().commit();
        session.close();
    }

    public void delete(Employee employee) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.getTransaction().begin();

        // this is the only line that changed
        session.delete(employee);

        session.getTransaction().commit();
        session.close();
    }


    public Employee findById(Integer id) {
        // these 2 lines of code prepare the hibernate session for use
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        // JPA Query - the syntax is slightly different than regular SQL
        String hql = "SELECT e FROM Employee e where e.id = :id";

        // this typed query is how hibernate knows what kind of object of fill up with the query results
        TypedQuery<Employee> query = session.createQuery(hql,Employee.class);

        // this is similar to the prepared statement, we are going to set the value in the query :firstname
        // to the value passed into the function
        query.setParameter("id", id);

        // we know we are querying a PK so the result will either be found or not found
        // unfortunately, in 2010 this implementation throws an exception if the record is not found
        // this does not exist in 2024
        try {
            Employee result = query.getSingleResult();
            return result;
        } catch ( Exception e ) {
            return null;
        } finally {
            // finally we close the hibernate session so it can release the resources its holding
            // specifically the connection pool and close the transaction
            session.close();
        }

    }



    public List<Employee> findByFirstName(String firstName) {
        // these 2 lines of code prepare the hibernate session for use
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        // JPA Query - the syntax is slightly different than regular SQL
        // SQL - "select * from employees e where e.firstname = ?"
        String hql = "SELECT e FROM Employee e where e.firstname = :firstname";

        // this typed query is how hibernate knows what kind of object of fill up with the query results
        TypedQuery<Employee> query = session.createQuery(hql,Employee.class);

        // this is similar to the prepared statement, we are going to set the value in the query :firstname
        // to the value passed into the function
        query.setParameter("firstname", firstName);

        // when we know we are getting 0 or more records we use getResultList
        List<Employee> result = query.getResultList();

        // finally we close the hibernate session so it can release the resources its holding
        // specifically the connection pool and close the transaction
        session.close();

        return result;
    }

    public List<Employee> findByLastName(String lastName) {
        // these 2 lines of code prepare the hibernate session for use
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        // JPA Query - the syntax is slightly different than regular SQL
        // SQL - "select * from employees e where e.lastname = ?"
        String hql = "SELECT e FROM Employee e where e.lastname = :lastname";

        // this typed query is how hibernate knows what kind of object of fill up with the query results
        TypedQuery<Employee> query = session.createQuery(hql,Employee.class);

        // this is similar to the prepared statement, we are going to set the value in the query :lastname
        // to the value passed into the function
        query.setParameter("lastname", lastName);

        // when we know we are getting 0 or more records we use getResultList
        List<Employee> result = query.getResultList();

        // finally we close the hibernate session so it can release the resources its holding
        // specifically the connection pool and close the transaction
        session.close();

        return result;
    }
}
