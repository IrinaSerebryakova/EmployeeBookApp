package com.employee.EmployeeBook;

import com.employee.EmployeeBook.exception.ArrayIsFull;
import com.employee.EmployeeBook.exception.EmployeeAlreadyAdded;
import com.employee.EmployeeBook.exception.EmployeeNotFound;

import java.util.Map;

public interface EmployeeService {
    String checkTheInputOfName(String name);
    Employee put(String firstName, String lastName, int department, double salary) throws EmployeeAlreadyAdded, ArrayIsFull;
    String remove(String firstName, String lastName) throws EmployeeNotFound;
    Employee find(String firstName, String lastName) throws EmployeeNotFound;
    Map<Integer, Employee> printAll();
}
