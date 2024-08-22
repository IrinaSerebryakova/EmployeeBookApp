package com.employee.EmployeeBook;

import com.employee.EmployeeBook.exception.ArrayIsFull;
import com.employee.EmployeeBook.exception.EmployeeAlreadyAdded;
import com.employee.EmployeeBook.exception.EmployeeNotFound;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class Controller {
    private final EmployeeServiceImpl employeeService;
    public Controller(EmployeeServiceImpl employeeService) {   // инжектим сервис в контроллер
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/put")
    public Employee put(@RequestParam ("fullName") String fullName,
                        @RequestParam ("value") int value) throws EmployeeAlreadyAdded, ArrayIsFull {
                     return employeeService.put(fullName,value);
    }

    @GetMapping(path = "/remove")
     public Employee remove(@RequestParam ("fullName") String fullName) throws EmployeeNotFound {
        return employeeService.remove(fullName);
    }
    @GetMapping(path = "/find")
    public Employee find(@RequestParam ("fullName") String fullName) throws EmployeeNotFound {
       return  employeeService.find(fullName);
    }

    @GetMapping
    public Map<String, Integer> print(){
        return employeeService.print();
    }
}
