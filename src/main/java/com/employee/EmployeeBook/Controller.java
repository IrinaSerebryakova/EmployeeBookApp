package com.employee.EmployeeBook;

import com.employee.EmployeeBook.exception.ArrayIsFull;
import com.employee.EmployeeBook.exception.EmployeeAlreadyAdded;
import com.employee.EmployeeBook.exception.EmployeeNotFound;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    private final EmployeeServiceImpl employeeService;
    public Controller(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }
    @RequestMapping(path = "/employee")
    public String welcome(){
        return employeeService.welcome();
    }
    @RequestMapping(path = "/employee/add")
    public String add(String firstName, String lastName) throws EmployeeAlreadyAdded, ArrayIsFull {
        return employeeService.add(firstName,lastName);
    }

    @RequestMapping(path = "/employee/remove")
     public String remove(String firstName, String lastName) throws EmployeeNotFound {
        return employeeService.remove(firstName,lastName);
    }
    @RequestMapping(path = "/employee/find")
    public String find(String firstName, String lastName) throws EmployeeNotFound {
        return employeeService.find(firstName,lastName);
    }

    @RequestMapping(path = "/employee/print")
    public List printInfo(List <Employee> employees){
        return employeeService.printInfo(employees);
    }
}
