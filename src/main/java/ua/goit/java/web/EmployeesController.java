package ua.goit.java.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.java.service.EmployeeService;

import java.util.Map;

/**
 * Created by bulov on 22.04.2017.
 */

@Controller
public class EmployeesController {
    private EmployeeService employeeService;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String employees(Map<String, Object> model){
        model.put("employees", employeeService.getEmployees());
        return "employees";
    }

    @RequestMapping(value = "/employee/{employeeName}", method = RequestMethod.GET)
    public ModelAndView employee(@PathVariable String employeeName){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employee", employeeService.getEmployeeName(employeeName));
        modelAndView.setViewName("employee");
        return modelAndView;
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
