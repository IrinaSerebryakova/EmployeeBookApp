package com.employee.EmployeeBook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.groupingBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {
    @Mock
    private EmployeeService employeeServiceMock = mock(EmployeeService.class);
   @InjectMocks
    private DepartmentService departmentService = mock(DepartmentService.class);

    @Test
    public void shouldFindEmployeeWithMaxSalary() {
        when(departmentService.findEmployeeWithMaxSalary(2))
                .thenReturn(employeeServiceMock.printAll().values()
                        .stream().filter(e -> e.getDepartment() == 2)
                        .max(comparingInt(e -> e.getSalary())).get());

        Assertions.assertEquals(2, departmentService.findEmployeeWithMaxSalary(2));
        verify(departmentService, times(1)).findEmployeeWithMaxSalary(2);
    }

    @Test
    public void shouldFindEmployeeWithMinSalary() {
        when(departmentService.findEmployeeWithMinSalary(2))
                .thenReturn(employeeServiceMock.printAll().values()
                        .stream().filter(e -> e.getDepartment() == 2)
                        .min(comparingInt(e -> e.getSalary())).get());

        Assertions.assertEquals(2, departmentService.findEmployeeWithMinSalary(2));
        verify(departmentService, atLeast(1)).findEmployeeWithMinSalary(2);
    }

    @Test
    public void shouldFindEmployeesByDepartments() {
        when(departmentService.findEmployeesByDepartments())
                .thenReturn(employeeServiceMock.printAll().values()
                        .stream().sorted(comparing(e -> e.getLastName()))
                        .collect(groupingBy(Employee::getDepartment)));

        List<Employee> employeesByDepartments = new ArrayList<>(List.of(
                new Employee("Пугачёва", "Алла", 1, 465000),
                new Employee("Киркоров", "Филипп", 1, 455000),
                new Employee("Козлов", "Игорь", 2, 225000),
                new Employee("Козлов", "Иван", 2, 125000),
                new Employee("Бронина", "Виктория", 2, 120000),
                new Employee("Сухоруков", "Вячеслав", 2, 120000),
                new Employee("Козлов", "Святослав", 3, 156000),
                new Employee("Восточная", "Марина", 4, 110000),
                new Employee("Сухорукова", "Светлана", 4, 138000),
                new Employee("Васильева", "Эльвира", 5, 75000)
        ));

        assertEquals(departmentService.findEmployeesByDepartments(), employeesByDepartments);
        verify(departmentService, atLeast(1)).findEmployeesByDepartments();
    }

    @Test
    public void shouldFindEmployeesByDepartments(int department) {
        when(departmentService.findEmployeesByDepartment(2))
                .thenReturn(employeeServiceMock.printAll().values().stream()
                        .filter(e -> e.getDepartment() == 2)
                        .collect(Collectors.toList()));

        List<Employee> secondDepartment = new ArrayList<>(List.of(
                new Employee("Козлов", "Игорь", 2, 225000),
                new Employee("Козлов", "Иван", 2, 125000),
                new Employee("Бронина", "Виктория", 2, 120000),
                new Employee("Сухоруков", "Вячеслав", 2, 120000)));

        assertEquals(departmentService.findEmployeesByDepartment(2), secondDepartment);
        verify(departmentService, atLeast(1)).findEmployeesByDepartment(2);
    }

    @Test
    public void shouldReturnEmptyListWhenDepartmentDoNotExist() {
        when(departmentService.findEmployeesByDepartment(10))
                .thenReturn(emptyList());
        assertTrue(departmentService.findEmployeesByDepartment(10).isEmpty());
    }
}
