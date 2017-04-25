package ua.goit.java.dao;

import ua.goit.java.model.Order;

import java.util.List;

/**
 * Created by bulov on 14.03.2017.
 */
public interface OrderDao {

    void save(Order order);

    List<Order> findAll();

    void removeAll();
}
