package com.employee.EmployeeBook;

import com.employee.EmployeeBook.exception.EmployeeAlreadyAddedException;
import com.employee.EmployeeBook.exception.EmployeeNotFoundException;
import com.employee.EmployeeBook.exception.IncorrectInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.*;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceImplTest {
     EmployeeServiceImpl service = new EmployeeServiceImpl();

    @Test
    public void putNewEmployeeAndGetCorrectResult() {
        String lastName = "Сухоруков";
        String firstName = "Вячеслав";
        int salary = 120000;
        int dep = 2;

        Employee actual = employeeService.put(lastName, firstName, dep, salary);

        assertEquals(actual.getLastName(), lastName);
        assertEquals(actual.getFirstName(), firstName);
        assertEquals(actual.getDepartment(), dep);
        assertEquals(actual.getSalary(), salary);
    }

    @Test
    public void putEmployeeAndGetIncorrectInputExceptionIfNumberZeroOrNegative() {
        assertThrows(IncorrectInputException.class,
                () -> employeeService.put("Сухоруков", "Вячеслав", -1, -2));
    }

    @Test
    public void putEmployeeWithNonCorrectNameAndGetSuccessfulAddingWithRightName() {
        String lastName = "сУхоРуКов";
        String firstName = "вЯчЕсЛаВ";
        int salary = 120000;
        int dep = 2;

        Employee actual = employeeService.put(lastName, firstName, dep, salary);

        assertEquals(actual.getLastName(), capitalize(lowerCase(lastName)));
        assertEquals(actual.getFirstName(), capitalize(lowerCase(firstName)));
        assertEquals(actual.getDepartment(), dep);
        assertEquals(actual.getSalary(), salary);
    }

    @Test
    public void putEmployeeAlreadyExistAndGetEmployeeAlreadyAddedException() {
        String lastName = "Сухоруков";
        String firstName = "Вячеслав";
        int salary = 120000;
        int dep = 2;

        employeeService.put(lastName, firstName, dep, salary);

        assertThrows(EmployeeAlreadyAddedException.class,
                () -> employeeService.put(lastName, firstName, dep, salary));
    }

    @Test
    public void removeNotExistEmployeeAndGetEmployeeNotFoundException() {
        assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.remove("Сухоруков", "Вячеслав"));
    }

    @Test
    public void removeExistEmployeeAndGetReturnRemovingEmployee() {
        String lastName = "Сухоруков";
        String firstName = "Вячеслав";
        int salary = 120000;
        int dep = 2;
        employeeService.put(lastName, firstName, dep, salary);

        Employee remove = employeeService.remove(lastName, firstName);

        assertEquals(remove.getLastName(), lastName);
        assertEquals(remove.getFirstName(), firstName);
        assertEquals(remove.getDepartment(), dep);
        assertEquals(remove.getSalary(), salary);
    }
}
