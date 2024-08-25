package com.employee.EmployeeBook;

import java.util.Collection;

public interface DepartmentService {
    Employee findEmployeeWithMaxSalary(int department);

    Employee findEmployeeWithMinSalary(int department);

    Object findEmployeesByDepartment();


    String findEmployeesByDepartment(Integer department);

}

