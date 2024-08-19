package com.employee.EmployeeBook;

import com.employee.EmployeeBook.exception.ArrayIsFull;
import com.employee.EmployeeBook.exception.EmployeeAlreadyAdded;
import com.employee.EmployeeBook.exception.EmployeeNotFound;

import java.util.List;

public interface EmployeeService {
    String welcome();
    String add(String firstName, String lastName) throws EmployeeAlreadyAdded, ArrayIsFull;
    String remove(String firstName, String lastName) throws EmployeeNotFound;
    String find(String firstName, String lastName) throws EmployeeNotFound;

    List printInfo(List list);
    void checkForArrayIsFull(List<Employee> employees);
    List<Employee> getEmployees();
}
