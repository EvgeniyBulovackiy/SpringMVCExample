package ua.goit.java.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.model.Employee;
import ua.goit.java.dao.EmployeeDao;

import java.util.List;

/**
 * Created by bulov on 14.03.2017.
 */
public class HEmployeeDao implements EmployeeDao{

    private SessionFactory sessionFactory;


    @Override
    public void save(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
    }

    @Override
    public Employee load(Long id) {
        return sessionFactory.getCurrentSession().load(Employee.class, id);
    }

   @Override
    public Employee findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Employee e where e.name like :name");
        query.setParameter("name", name);
        return (Employee) query.uniqueResult();
    }

   @Override
    public List<Employee> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select e from Employee e").list();
    }

    @Override
    public void remove(Employee employee) {
        sessionFactory.getCurrentSession().delete(employee);
    }

    @Override
    public void removeAll() {
        sessionFactory.getCurrentSession().createQuery("delete from Employee ").executeUpdate();
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


}
