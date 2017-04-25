package ua.goit.java.dao;

import ua.goit.java.model.Employee;

import java.util.List;

/**
 * Created by bulov on 14.03.2017.
 */
public interface EmployeeDao {

    void save(Employee employee);

    Employee load(Long id);

    List<Employee> findAll();

    Employee findByName(String name);

    void remove(Employee employee);

    void removeAll();

}
