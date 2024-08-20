package com.employee.EmployeeBook;

import com.employee.EmployeeBook.exception.ArrayIsFull;
import com.employee.EmployeeBook.exception.EmployeeAlreadyAdded;
import com.employee.EmployeeBook.exception.EmployeeNotFound;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class Controller {
    private final EmployeeServiceImpl employeeService;
    public Controller(EmployeeServiceImpl employeeService) {   // инжектим сервис в контроллер
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee add(@RequestParam ("firstName") String firstName,
                      @RequestParam ("lastName") String lastName) throws EmployeeAlreadyAdded, ArrayIsFull {
        return employeeService.add(firstName,lastName);
    }

    @GetMapping(path = "/remove")
     public Employee remove(@RequestParam ("firstName") String firstName,
                            @RequestParam ("lastName") String lastName) throws EmployeeNotFound {
        return employeeService.remove(firstName,lastName);
    }
    @GetMapping(path = "/find")
    public Employee find(@RequestParam ("firstName") String firstName,
                         @RequestParam ("lastName") String lastName) throws EmployeeNotFound {
       return  employeeService.find(firstName,lastName);
    }

    @GetMapping
    public Collection<Employee> print(){
        return employeeService.print();
    }
}
