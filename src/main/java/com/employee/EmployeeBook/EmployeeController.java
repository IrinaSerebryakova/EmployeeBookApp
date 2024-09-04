package com.employee.EmployeeBook;

import com.employee.EmployeeBook.exception.ArrayIsFull;
import com.employee.EmployeeBook.exception.EmployeeAlreadyAdded;
import com.employee.EmployeeBook.exception.EmployeeNotFound;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;
    public EmployeeController(EmployeeServiceImpl employeeService) {   // инжектим сервис в контроллер
        this.employeeService = employeeService;
    }
    @GetMapping(path = "/put")
    public Employee put(@RequestParam ("lastName") String lastName,
                        @RequestParam ("firstName") String firstName,
                        @RequestParam ("department") int department,
                        @RequestParam ("salary") int salary) throws EmployeeAlreadyAdded, ArrayIsFull {
                     return employeeService.put(lastName,firstName,department,salary);
    }
    @GetMapping(path = "/remove")
     public Employee remove(@RequestParam ("lastName") String lastName,
                          @RequestParam ("firstName") String firstName) throws EmployeeNotFound {
        return employeeService.remove(lastName,firstName);
    }
    @GetMapping(path = "/find")
    public Employee find(@RequestParam ("lastName") String lastName,
                         @RequestParam ("firstName") String firstName) throws EmployeeNotFound {
       return  employeeService.find(lastName,firstName);
    }

    @GetMapping
    public String printAll(){
        return employeeService.printAll().toString();
    }
}
