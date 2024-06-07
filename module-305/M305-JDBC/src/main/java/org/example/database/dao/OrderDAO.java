package org.example.database.dao;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.example.database.entity.Order;
import org.example.database.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OrderDAO {

    SessionFactory factory = new Configuration().configure().buildSessionFactory();


    void insert(Order order) {
        Session session = factory.openSession();
        session.getTransaction().begin();

        // this is the only line that changed
        session.save(order);

        session.getTransaction().commit();
        session.close();
    }

    void update(Order order) {
        Session session = factory.openSession();
        session.getTransaction().begin();

        // this is the only line that changed
        session.merge(order);

        session.getTransaction().commit();
        session.close();
    }

    public Order findById(Integer id) {
        // these 2 lines of code prepare the hibernate session for use
        Session session = factory.openSession();

        String hql = "select o from Order o where o.id = :id";

        // this is setting up the query (essentially this is using a prepared statement inside)
        TypedQuery<Order> query = session.createQuery(hql,Order.class);
        // this is substituting the incoming id variable into the query string above
        // select * from Orders where id = 100;
        query.setParameter("id", id);

        try {
            // getSingleResult will throw an exception if no records are found
            Order Order = query.getSingleResult();

            // if we get here then a record was found so we can return it
            return Order;
        } catch( NoResultException e ) {
            // if we land here it is because there was an exception where there was no result
            // the standard design pattern is to return null when no record was found
            return null;
        } finally {
            // no matter what happens we want to close the hibernate session
            session.close();
        }
    }

}
