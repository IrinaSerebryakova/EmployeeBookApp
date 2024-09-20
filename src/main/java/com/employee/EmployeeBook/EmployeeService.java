package com.employee.EmployeeBook;

import com.employee.EmployeeBook.exception.ArrayIsFull;
import com.employee.EmployeeBook.exception.EmployeeAlreadyAdded;
import com.employee.EmployeeBook.exception.EmployeeNotFound;

import java.util.Map;

public interface EmployeeService {
    Employee put(String lastName, String firstName, int department, int salary) throws EmployeeAlreadyAdded, ArrayIsFull;
    Employee remove(String lastName, String firstName) throws EmployeeNotFound;
    Employee find(String lastName, String firstName) throws EmployeeNotFound;
    Map<String, Employee> printAll();
    String checkAndCorrectName(String name);
    void checkNumber(Integer... numbers);

}
