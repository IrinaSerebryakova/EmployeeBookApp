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
    public Employee put(@RequestParam ("firstName") String firstName,
                        @RequestParam ("lastName") String lastName,
                        @RequestParam ("departmentId") int department,
                        @RequestParam ("salary") double salary) throws EmployeeAlreadyAdded, ArrayIsFull {
                     return employeeService.put(firstName,lastName,department,salary);
    }
    @GetMapping(path = "/remove")
     public String remove(@RequestParam ("firstName") String firstName,
                          @RequestParam ("lastName") String lastName) throws EmployeeNotFound {
        return employeeService.remove(firstName,lastName);
    }
    @GetMapping(path = "/find")
    public Employee find(@RequestParam ("firstName") String firstName,
                         @RequestParam ("lastName") String lastName) throws EmployeeNotFound {
       return  employeeService.find(firstName,lastName);
    }

    @GetMapping
    public String printAll(){
        return employeeService.printAll().toString();
    }
}
