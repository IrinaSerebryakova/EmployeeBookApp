package com.employee.EmployeeBook;

import com.employee.EmployeeBook.exception.ArrayIsFullException;
import com.employee.EmployeeBook.exception.EmployeeAlreadyAddedException;
import com.employee.EmployeeBook.exception.EmployeeNotFoundException;

import java.util.Map;

public interface EmployeeService {
    Employee put(String lastName, String firstName, int department, int salary) throws EmployeeAlreadyAddedException, ArrayIsFullException;
    Employee remove(String lastName, String firstName) throws EmployeeNotFoundException;
    Employee find(String lastName, String firstName) throws EmployeeNotFoundException;
    Map<String, Employee> printAll();
    String checkAndCorrectName(String name);
    void checkNumber(Integer... numbers);

}
