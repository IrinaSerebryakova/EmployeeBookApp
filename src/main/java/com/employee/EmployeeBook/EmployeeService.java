package com.employee.EmployeeBook;

import com.employee.EmployeeBook.exception.ArrayIsFull;
import com.employee.EmployeeBook.exception.EmployeeAlreadyAdded;
import com.employee.EmployeeBook.exception.EmployeeNotFound;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName) throws EmployeeAlreadyAdded, ArrayIsFull;
    Employee remove(String firstName, String lastName) throws EmployeeNotFound;
    Employee find(String firstName, String lastName) throws EmployeeNotFound;
    Collection<Employee> print();
}
