package ua.goit.java.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.dao.DishDao;
import ua.goit.java.model.Dish;

import java.util.List;

/**
 * Created by bulov on 14.03.2017.
 */
public class HDishDao implements DishDao {

    private SessionFactory sessionFactory;

    @Override
    public void save(Dish dish) {
        sessionFactory.getCurrentSession().save(dish);
    }

   @Override
    public Dish findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select d from Dish d where d.name like :name");
        query.setParameter("name", name);
        return (Dish) query.uniqueResult();
    }

    @Override
    public void removeAll() {
        sessionFactory.getCurrentSession().createQuery("delete from Dish ").executeUpdate();
    }

    @Override
    public List<Dish> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select d from Dish d").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
