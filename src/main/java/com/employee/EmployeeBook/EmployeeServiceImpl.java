package com.employee.EmployeeBook;

import com.employee.EmployeeBook.exception.ArrayIsFull;
import com.employee.EmployeeBook.exception.EmployeeAlreadyAdded;
import com.employee.EmployeeBook.exception.EmployeeNotFound;
import com.employee.EmployeeBook.exception.IncorrectInput;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.isAlpha;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    static Map<Integer, Employee> employees = new HashMap<>(Map.of(
            0, new Employee("Пугачёва", "Алла", 1, 465000.00),
            1, new Employee("Филипп", "Киркоров", 1, 455000.00),
            2, new Employee("Игорь", "Козлов", 2, 225000.00),
            3, new Employee("Иван", "Козлов", 2, 125000.00),
            4, new Employee("Виктория", "Бронина", 2, 120000.00),
            5, new Employee("Святослав", "Козлов", 3, 156000.00),
            6, new Employee("Марина", "Восточная", 4, 110000.00),
            7, new Employee("Эльвира", "Васильева", 5, 75000.00),
            8, new Employee("Светлана", "Сухорукова", 4, 138000.00),
            9, new Employee("Вячеслав", "Сухоруков", 2, 120000.00)
    ));

    public static Map<Integer, Employee> getEmployees() {
        return employees;
    }

    public String checkTheInputOfName(String name) {
        if (isAlpha(name)) {
            return name;
        }
        throw new IncorrectInput("Некорректный ввод");
    }


    @Override
    public Employee put(String firstName, String lastName, int department, double salary) throws EmployeeAlreadyAdded, ArrayIsFull {
        checkTheInputOfName(firstName);
        checkTheInputOfName(lastName);
        for (Employee employee : employees.values()) {
            if (employee.getFirstName() != firstName && employee.getLastName() != lastName) {
                employees.put(employees.size(), new Employee(firstName, lastName, department, salary));
            }
            throw new EmployeeAlreadyAdded("Сотрудник уже существует");
        }
        return new Employee(firstName, lastName, department, salary);
    }


    @Override
    public String remove(String firstName, String lastName) throws EmployeeNotFound {
        checkTheInputOfName(firstName);
        checkTheInputOfName(lastName);
        for (Employee employee : employees.values()) {
            if (employee.getFirstName() == firstName && employee.getLastName() == lastName) {
                employees.remove(firstName, lastName);
            }
        }
        throw new EmployeeNotFound("Сотрудник не найден");
    }

    @Override
    public Employee find(String firstName, String lastName) throws EmployeeNotFound {
            checkTheInputOfName(firstName);
            checkTheInputOfName(lastName);
            for (Employee employee : employees.values()) {
                if (employee.getFirstName().contains(firstName) && employee.getLastName().contains(lastName)) {
                    return employee;
                }
            }
        throw new EmployeeNotFound("Сотрудник не найден");
        }

    @Override
    public Map<Integer, Employee> printAll() {
        return employees;
    }
}