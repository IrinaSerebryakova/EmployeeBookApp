package com.employee.EmployeeBook;

import com.employee.EmployeeBook.exception.ArrayIsFull;
import com.employee.EmployeeBook.exception.EmployeeAlreadyAdded;
import com.employee.EmployeeBook.exception.EmployeeNotFound;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeServiceImpl employeeService;
    public void Controller(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }
    private Employee generalManager = new Employee("Пугачёва","Алла");
    private Employee mainEngineer = new Employee("Козлов","Игорь");
    private Employee economist = new Employee("Восточная","Марина");
    private Employee secretary = new Employee("Васильева","Эльвира");
    private Employee accountant = new Employee("Сухорукова","Светлана");
    private Employee worker = new Employee("Сухоруков","Вячеслав");
    private final List<Employee> employees = new ArrayList<>(List.of(generalManager,worker,economist,secretary,accountant,mainEngineer,null,null));
    public boolean isFull;

    @Override
    public List<Employee> getEmployees() {
        return employees;
    }


    @Override
    public String welcome() {
        return "Добро пожаловать в сервис Employee";
    }

    @Override
    public String add(@RequestParam String firstName, @RequestParam String lastName) throws EmployeeAlreadyAdded, ArrayIsFull {
        checkForArrayIsFull(employees);
        Employee current = new Employee(firstName,lastName);
        if(isFull == true){
            throw new ArrayIsFull("Массив переполнен");
        }
        if(employees.contains(current)){
            throw new EmployeeAlreadyAdded("Сотрудник уже существует");
        }
        if(!employees.contains(current)){
            employees.set(employees.size(),current);
        }
        return current.toString();
    }

    @Override
    public String remove(@RequestParam String firstName,@RequestParam String lastName) throws EmployeeNotFound {
        Employee current = new Employee(firstName,lastName);
        if (firstName.equals("") || lastName.equals("")) {
            return "Error";
        }else if(!employees.contains(current)){
            throw new EmployeeNotFound("Сотрудник не найден");
        }else{
            employees.remove(current);
        }
        return current.toString();
    }

    @Override
    public String find(@RequestParam String firstName,@RequestParam String lastName) throws EmployeeNotFound {
        Employee current = new Employee(firstName,lastName);
        if (firstName.equals("") || lastName.equals("")) {
            return "Error";
        }else if(!employees.contains(current)){
            throw new EmployeeNotFound("Сотрудник не найден");
        }else{
            return current.toString();
        }
    }

    @Override
    public List printInfo(@RequestParam List list){
        return getEmployees();
    }

    @Override
    public void checkForArrayIsFull(List<Employee> employees){
        int counter = employees.size();
        for (int i = 0; i < employees.size(); i++) {
            if(employees.get(i) != null){
                counter--;
            }
            if (counter == 0){
                isFull = true;
            }
        }
    }
}

