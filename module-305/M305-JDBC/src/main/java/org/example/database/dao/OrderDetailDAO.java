package org.example.database.dao;

import jakarta.persistence.TypedQuery;
import org.example.database.entity.Employee;
import org.example.database.entity.Order;
import org.example.database.entity.OrderDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OrderDetailDAO {

    SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void update(OrderDetail orderDetail) {
        Session session = factory.openSession();
        session.getTransaction().begin();

        // this is the only line that changed
        session.merge(orderDetail);

        session.getTransaction().commit();
        session.close();
    }


    public void insert(OrderDetail orderDetail) {
        Session session = factory.openSession();
        session.getTransaction().begin();

        // this is the only line that changed
        session.save(orderDetail);

        session.getTransaction().commit();
        session.close();
    }

    public OrderDetail findByOrderIdAndProductId(Integer orderId, Integer productId) {
        Session session = factory.openSession();

        String hql = "SELECT od FROM OrderDetail od where od.product.id = :productId and od.order.id = :orderId";

        TypedQuery<OrderDetail> query = session.createQuery(hql,OrderDetail.class);
        query.setParameter("orderId", orderId);
        query.setParameter("productId", productId);

        try {
            OrderDetail result = query.getSingleResult();
            return result;
        } catch ( Exception e ) {
            return null;
        } finally {
           session.close();
        }
    }

}
