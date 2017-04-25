package ua.goit.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.dao.EmployeeDao;
import ua.goit.java.model.Employee;

import java.util.List;

/**
 * Created by bulov on 22.04.2017.
 */

public class EmployeeService {
    private EmployeeDao employeeDao;

    @Transactional
    public List getEmployees(){
        return employeeDao.findAll();
    }

    @Transactional
    public Employee getEmployeeName(String employeeName) {
        return employeeDao.findByName(employeeName);
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }


}
