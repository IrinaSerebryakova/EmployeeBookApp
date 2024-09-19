package com.employee.EmployeeBook;

import com.employee.EmployeeBook.exception.ArrayIsFull;
import com.employee.EmployeeBook.exception.EmployeeAlreadyAdded;
import com.employee.EmployeeBook.exception.EmployeeNotFound;
import com.employee.EmployeeBook.exception.IncorrectInput;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.Arrays.stream;
import static org.apache.commons.lang3.StringUtils.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    Map<String, Employee> employees = new HashMap<>(Map.of(
            "Пугачёва Алла", new Employee("Пугачёва", "Алла", 1, 465000),
            "Киркоров Филипп", new Employee("Киркоров", "Филипп", 1, 455000),
            "Козлов Игорь", new Employee("Козлов", "Игорь", 2, 225000),
            "Козлов Иван", new Employee("Козлов", "Иван", 2, 125000),
            "Бронина Виктория", new Employee("Бронина", "Виктория", 2, 120000),
            "Козлов Святослав", new Employee("Козлов", "Святослав", 3, 156000),
            "Восточная Марина", new Employee("Восточная", "Марина", 4, 110000),
            "Васильева Эльвира", new Employee("Васильева", "Эльвира", 5, 75000),
            "Сухорукова Светлана", new Employee("Сухорукова", "Светлана", 4, 138000),
            "Сухоруков Вячеслав", new Employee("Сухоруков", "Вячеслав", 2, 120000)
    ));

    @Override
    public Employee put(String lastName, String firstName, int department, int salary) throws EmployeeAlreadyAdded, ArrayIsFull {
        lastName = checkAndCorrectName(lastName);
        firstName = checkAndCorrectName(firstName);
        checkNumber(department,salary);
        String fullName = lastName + " " + firstName;
        if (!employees.containsKey(fullName)) {
            Employee newEmployee = new Employee(lastName, firstName, department, salary);
            employees.put(fullName,newEmployee);
            return newEmployee;
        }
        throw new EmployeeAlreadyAdded("Сотрудник уже существует");
    }

    @Override
    public String checkAndCorrectName(String name) {
            if (!isAlpha(name) || name == null) {
                throw new IncorrectInput("Неправильный ввод имени");
            }
           return capitalize(lowerCase(name));
    }

    @Override
    public void checkNumber(Integer... numbers) {
        for (Integer number : numbers) {
            if (!isNumeric(Integer.toString(number)) || number == 0 || number < 0) {
                throw new IncorrectInput("Необходимо ввести цифровое значение");
            }
        }
    }

    @Override
    public Employee remove(String lastName, String firstName) throws EmployeeNotFound {
        lastName = checkAndCorrectName(lastName);
        firstName = checkAndCorrectName(firstName);
        String fullName = lastName + " " + firstName;
        if (employees.containsKey(fullName)) {
            Employee markToRemove = employees.get(fullName);
            employees.remove(fullName);
            return markToRemove;
        }
        throw new EmployeeNotFound("Сотрудник не найден");
    }

    @Override
    public Employee find(String lastName, String firstName) throws EmployeeNotFound {
        lastName = checkAndCorrectName(lastName);
        firstName = checkAndCorrectName(firstName);
        String fullName = lastName + " " + firstName;
        if (employees.containsKey(fullName)) {
            return employees.get(fullName);
        }
        throw new EmployeeNotFound("Сотрудник не найден");
    }

    @Override
    public Map<String, Employee> printAll() {
        return employees;
    }
}