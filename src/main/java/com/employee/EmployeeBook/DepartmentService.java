package com.employee.EmployeeBook;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee findEmployeeWithMaxSalary(int department);
    Employee findEmployeeWithMinSalary(int department);
    Map<Integer, List<Employee>> findEmployeesByDepartments();
    List<Employee> findEmployeesByDepartment(int department);
}

