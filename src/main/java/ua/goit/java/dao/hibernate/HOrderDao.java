package ua.goit.java.dao.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.dao.OrderDao;
import ua.goit.java.model.Order;

import java.util.List;

/**
 * Created by bulov on 14.03.2017.
 */

public class HOrderDao implements OrderDao{

    private SessionFactory sessionFactory;

    public void save(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }

    @Override
    public List<Order> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select o from Order o").list();
    }

    @Override
    public void removeAll() {
        sessionFactory.getCurrentSession().createQuery("delete from Order ").executeUpdate();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
