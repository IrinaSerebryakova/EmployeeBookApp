package com.employee.EmployeeBook;

import org.springframework.stereotype.Service;
import com.employee.EmployeeBook.exception.EmployeeNotFound;

import java.util.*;
import java.util.stream.Collectors;
import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeServiceImpl employeeService;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findEmployeeWithMaxSalary(int department) {
        return employeeService.printAll().entrySet().stream()
                .filter(e -> e.getDepartment() == department)
                .max(comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFound::new);
    }

    @Override
    public Employee findEmployeeWithMinSalary(int department) {
        return employeeService.printAll().entrySet().stream()
                .filter(e -> e.getDepartment() == department)
                .min(comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFound::new);
    }


    @Override
    public Map<Integer, List<Employee>> findEmployeesByDepartments(){
        return employeeService.printAll().stream()
                .sorted(comparing(Employee::getLastName).thenComparing(Employee::getFirstName))
                .collect(groupingBy(Employee::getDepartment));
    }
    @Override
    public List<Map.Entry<String, Employee>> findEmployeesByDepartment(int department) {
        return  employeeService.printAll().entrySet().stream()
                .filter(e -> e.getValue().getDepartment() == department)
                .sorted()
                .collect(Collectors.toList());
    }
}

