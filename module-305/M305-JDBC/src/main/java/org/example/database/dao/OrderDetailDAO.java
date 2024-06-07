package org.example.database.dao;

import org.example.database.entity.Order;
import org.example.database.entity.OrderDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OrderDetailDAO {

    SessionFactory factory = new Configuration().configure().buildSessionFactory();


    public void insert(OrderDetail orderDetail) {
        Session session = factory.openSession();
        session.getTransaction().begin();

        // this is the only line that changed
        session.save(orderDetail);

        session.getTransaction().commit();
        session.close();
    }

}
