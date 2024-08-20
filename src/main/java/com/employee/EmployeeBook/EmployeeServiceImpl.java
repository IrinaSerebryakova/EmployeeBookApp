package com.employee.EmployeeBook;

import com.employee.EmployeeBook.exception.ArrayIsFull;
import com.employee.EmployeeBook.exception.EmployeeAlreadyAdded;
import com.employee.EmployeeBook.exception.EmployeeNotFound;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Алла","Пугачёва"),
            new Employee("Игорь","Козлов"),
            new Employee("Марина","Восточная"),
            new Employee("Эльвира","Васильева"),
            new Employee("Светлана","Сухорукова"),
            new Employee("Вячеслав","Сухоруков")
    ));

    @Override
    public Employee add(String firstName, String lastName) throws EmployeeAlreadyAdded, ArrayIsFull {
        Employee current = new Employee(firstName, lastName);
        if (!employees.contains(current)) {
            employees.add(current);
            return current;
        }
        throw new EmployeeAlreadyAdded("Сотрудник уже существует");
    }


    @Override
    public Employee remove(String firstName,String lastName) throws EmployeeNotFound {
        Employee current = new Employee(firstName, lastName);
        if (employees.contains(current)) {
            employees.remove(current);
            return current;
        }
            throw new EmployeeNotFound("Сотрудник не найден");
    }

    @Override
    public Employee find(String firstName,String lastName) throws EmployeeNotFound {
        Employee current = new Employee(firstName,lastName);
        if(employees.contains(current)){
            return current;
        }
        throw new EmployeeNotFound("Сотрудник не найден");
    }
    @Override
    public Collection<Employee> print() {
        return Collections.unmodifiableList(employees);  // неизменяемая копия
    }
}

