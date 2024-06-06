package org.example.database.dao;

import jakarta.persistence.TypedQuery;
import org.example.database.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CustomerDAO {

    //-----------------------------Method findByCustomerName----------------------

    public List<Customer> findByCustomerName(String customer) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        String hqlCustomer = "SELECT c FROM Customer c WHERE c.customerName = :xcustomerName";

        TypedQuery<Customer> query = session.createQuery(hqlCustomer, Customer.class);
        query.setParameter("xcustomerName", customer);

        List<Customer> result = query.getResultList();

        session.close();

        return result;

    }
    //--------------------Method fidByContactFirstName-----------------------

    public List<Customer> fidByContactFirstName(String contactName) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        String hqlCustomer = "SELECT c FROM Customer c WHERE c.contactFirstname = :whatever";

        TypedQuery<Customer> query = session.createQuery(hqlCustomer, Customer.class);
        query.setParameter("whatever", contactName);

        List<Customer> result = query.getResultList();

        session.close();

        return result;

    }
//------------------------Method insert------------------------------------------

    public void insert(Customer customer) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.save(customer);
        session.getTransaction().commit();
        session.close();
    }

    //------------------method findById--------------------

    public Customer findById(Integer id) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        String hql = "SELECT c FROM Customer c where c.id = :xid";
        TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
        query.setParameter("xid", id);

        // we are querying a PK so the result can be found or not
        //this implementation will throw an exception in codes 2010 and under if the record is not found, so we put a
        // try-catch
        try {
            Customer result = query.getSingleResult();
            return result;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }


    //-------------------method update----------------------

    public void update(Customer customer) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.merge(customer);
        session.getTransaction().commit();
        session.close();
    }
    
}
