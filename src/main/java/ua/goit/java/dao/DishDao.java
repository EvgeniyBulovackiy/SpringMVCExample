package ua.goit.java.dao;

import ua.goit.java.model.Dish;

import java.util.List;

/**
 * Created by bulov on 14.03.2017.
 */
public interface DishDao {

    void save(Dish dish);

    Dish findByName(String name);

    List<Dish> findAll();

    void removeAll();

}
