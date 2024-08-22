package com.employee.EmployeeBook;

import com.employee.EmployeeBook.exception.ArrayIsFull;
import com.employee.EmployeeBook.exception.EmployeeAlreadyAdded;
import com.employee.EmployeeBook.exception.EmployeeNotFound;

import java.util.Map;

public interface EmployeeService {
    Employee put(String fullName, int value) throws EmployeeAlreadyAdded, ArrayIsFull;
    Employee remove(String fullName) throws EmployeeNotFound;
    Employee find(String fullName) throws EmployeeNotFound;
    Map<String, Integer> print();
}
