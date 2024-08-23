package com.employee.EmployeeBook;

import com.employee.EmployeeBook.exception.ArrayIsFull;
import com.employee.EmployeeBook.exception.EmployeeAlreadyAdded;
import com.employee.EmployeeBook.exception.EmployeeNotFound;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.Arrays.stream;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    Map<String, Employee> employees = new HashMap<>(Map.of(
            "Пугачёва Алла Борисовна", new Employee(1, 465000.00),
            "Киркоров Филипп Бедросове", new Employee(1, 455000.00),
            "Козлов Игорь Витальевич", new Employee(2, 225000.00),
            "Козлов Иван Игоревич", new Employee(2, 125000.00),
            "Бронина Виктория Васильевна", new Employee(2, 120000.00),
            "Козлов Святослав Иванович", new Employee(3, 156000.00),
            "Восточная Марина Васильевна", new Employee(4, 110000.00),
            "Васильева Эльвира Альбертовна", new Employee(5, 75000.00),
            "Сухорукова Светлана Аркадьевна", new Employee(4, 138000.00),
            "Сухоруков Вячеслав Викторович", new Employee(2, 120000.00)
            ));

    @Override
    public Employee put(String fullName, int department, double salary) throws EmployeeAlreadyAdded, ArrayIsFull {
        if (!employees.containsKey(fullName))
            employees.put(fullName, new Employee(department, salary));
            throw new EmployeeAlreadyAdded("Сотрудник уже существует");
    }


    @Override
    public Employee remove(String fullName) throws EmployeeNotFound {
        if (employees.containsKey(fullName)) {
            Employee current = new Employee(fullName, employees.get(fullName));
            employees.remove(fullName);

            return removed;
        }
        throw new EmployeeNotFound("Сотрудник не найден");
    }

    @Override
    public Employee find(String fullName) throws EmployeeNotFound {
        if (employees.containsKey(fullName)) {
            return new Employee(fullName, employees.get(fullName));
        }
        throw new EmployeeNotFound("Сотрудник не найден");
    }

}