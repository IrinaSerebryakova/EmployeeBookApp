package com.employee.EmployeeBook;

import com.employee.EmployeeBook.exception.DepartmentDoNotExistException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.employee.EmployeeBook.EmployeeData.departments;
import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.groupingBy;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeServiceImpl employeeService;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findEmployeeWithMaxSalary(int department) {
        return employeeService.printAll().values().stream()
                .filter(e -> e.getDepartment() == department)
                .max(comparingInt(e -> e.getSalary()))
                .get();
    }

    @Override
    public Employee findEmployeeWithMinSalary(int department) {
        return employeeService.printAll().values().stream()
                .filter(e -> e.getDepartment() == department)
                .min(comparingInt(e -> e.getSalary()))
                .get();
    }

    @Override
    public Map<Integer, List<Employee>> findEmployeesByDepartments() {
        return employeeService.printAll().values().stream()
                .sorted(comparing(e -> e.getLastName()))
                .collect(groupingBy(Employee::getDepartment));
    }

    @Override
    public List<Employee> findEmployeesByDepartment(int department) throws DepartmentDoNotExistException {
        if (department < 1 || department > 5 ){
                throw new DepartmentDoNotExistException("Департамент не существует!");
            }
        return employeeService.printAll().values().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }
}

