package com.employee.EmployeeBook;

import com.employee.EmployeeBook.exception.ArrayIsFull;
import com.employee.EmployeeBook.exception.EmployeeAlreadyAdded;
import com.employee.EmployeeBook.exception.EmployeeNotFound;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private Map<String, Integer> employees = new HashMap<>(Map.of(
            "Алла Пугачёва", 0,
            "Игорь Козлов", 1,
            "Марина Восточная", 2,
            "Эльвира Васильева", 3,
            "Светлана Сухорукова", 4,
            "Вячеслав Сухоруков", 5)
    );

    @Override
    public Employee put(String keyFullName, int value) throws EmployeeAlreadyAdded, ArrayIsFull {
        if(!employees.containsKey(keyFullName)){
            employees.put(keyFullName, value);
            return new Employee(keyFullName, value);
        }
        throw new EmployeeAlreadyAdded("Сотрудник уже существует");
    }


    @Override
    public Employee remove(String keyFullName) throws EmployeeNotFound {
        if(employees.containsKey(keyFullName)){
        employees.remove(keyFullName);
        Employee removed = new Employee(keyFullName, employees.get(keyFullName));
            return removed;
        }
        throw new EmployeeNotFound("Сотрудник не найден");
    }

    @Override
    public Employee find(String keyFullName) throws EmployeeNotFound {
        if(employees.containsKey(keyFullName)){
            return new Employee(keyFullName, employees.get(keyFullName));
        }
        throw new EmployeeNotFound("Сотрудник не найден");
    }

    @Override
    public Map<String, Integer> print() {
        return employees;
    }
}

