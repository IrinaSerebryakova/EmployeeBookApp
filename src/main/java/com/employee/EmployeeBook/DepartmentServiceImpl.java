package com.employee.EmployeeBook;

import com.employee.EmployeeBook.exception.EmployeeNotFound;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;

import static java.util.Comparator.comparingDouble;
import static java.util.stream.Collectors.toList;


@Service
public class DepartmentServiceImpl implements DepartmentService {
    private EmployeeServiceImpl employeeService;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findEmployeeWithMaxSalary(int department){
        return (Employee) employeeService.printAll().entrySet().stream()
                .filter(e -> e.getValue().getDepartment() == department)
                .max(comparingDouble(e -> e.getValue().getSalary()))
                .get();
    }

    @Override
    public Employee findEmployeeWithMinSalary(int department) {
        return (Employee) employeeService.printAll().entrySet().stream()
                .filter(e -> e.getValue().getDepartment() == department)
                .min(comparingDouble(e -> e.getValue().getSalary()))
                .get();
    }



    @Override
    public String findEmployeesByDepartment() {
        Map<Integer, Employee> employOf = Map.copyOf(employeeService.getEmployees());
        Map<Integer, Employee> employOfCollect = new HashMap<>();
        int[] department = {1, 2, 3, 4, 5};
        int indexCount = 0;
        for (Employee employee : employOf.values()) {
            for (int i = 1; i < department.length + 1; i++) {
                if (employee.getDepartment() == i) {
                    employOfCollect.put(indexCount,employee);
                    indexCount++;
                }
            }
        }
        return employOfCollect.toString();
    }



    @Override
    public String findEmployeesByDepartment(Integer department) {
        return employeeService.printAll().entrySet().stream()
                .filter(e -> e.getValue().getDepartment() == department)
                .collect(toList()).toString();
    }
}

