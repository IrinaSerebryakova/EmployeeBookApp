package com.employee.EmployeeBook;

import com.employee.EmployeeBook.exception.ArrayIsFullException;
import com.employee.EmployeeBook.exception.EmployeeAlreadyAddedException;
import com.employee.EmployeeBook.exception.EmployeeNotFoundException;
import com.employee.EmployeeBook.exception.IncorrectInputException;

import org.springframework.stereotype.Service;

import java.util.*;

import static com.employee.EmployeeBook.EmployeeData.employees;
import static org.apache.commons.lang3.StringUtils.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public Employee put(String lastName, String firstName, int department, int salary) throws EmployeeAlreadyAddedException, ArrayIsFullException {
        lastName = checkAndCorrectName(lastName);
        firstName = checkAndCorrectName(firstName);
        checkNumber(department,salary);
        String fullName = lastName + " " + firstName;
        if (!employees.containsKey(fullName)) {
            Employee newEmployee = new Employee(lastName, firstName, department, salary);
            employees.put(fullName,newEmployee);
            return newEmployee;
        }
        throw new EmployeeAlreadyAddedException("Сотрудник уже существует");
    }

    @Override
    public String checkAndCorrectName(String name) {
            if (!isAlpha(name) || name == null) {
                throw new IncorrectInputException("Неправильный ввод имени");
            }
           return capitalize(lowerCase(name));
    }

    @Override
    public void checkNumber(Integer... numbers) {
        for (Integer number : numbers) {
            if (number <= 0) {
                throw new IncorrectInputException("Необходимо ввести цифровое значение");
            }
        }
    }

    @Override
    public Employee remove(String lastName, String firstName) throws EmployeeNotFoundException {
        lastName = checkAndCorrectName(lastName);
        firstName = checkAndCorrectName(firstName);
        String fullName = lastName + " " + firstName;
        if (employees.containsKey(fullName)) {
            Employee markToRemove = employees.get(fullName);
            employees.remove(fullName);
            return markToRemove;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public Employee find(String lastName, String firstName) throws EmployeeNotFoundException {
        lastName = checkAndCorrectName(lastName);
        firstName = checkAndCorrectName(firstName);
        String fullName = lastName + " " + firstName;
        if (employees.containsKey(fullName)) {
            return employees.get(fullName);
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public Map<String, Employee> printAll() {
        return employees;
    }
}