package com.employee.EmployeeBook;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentServiceImpl departmentService;
    public DepartmentController(DepartmentServiceImpl departmentService) {   // инжектим сервис в контроллер
        this.departmentService = departmentService;
    }
    @GetMapping("/max-salary")
    public Employee findEmployeeWithMaxSalaryByDepartmentId(@RequestParam ("department") int department) {
        return departmentService.findEmployeeWithMaxSalary(department);
    }

    @GetMapping("/min-salary")
    public Employee findEmployeeWithMinSalaryByDepartmentId(@RequestParam ("department")int department) {
        return departmentService.findEmployeeWithMinSalary(department);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> findEmployees() {
        return departmentService.findEmployeesByDepartments();
    }

    @GetMapping(path = "/all", params = {"department"})
    public Collection<Employee>  findEmployees(@RequestParam int department) {
        return departmentService.findEmployeesByDepartment(department);
    }
}
