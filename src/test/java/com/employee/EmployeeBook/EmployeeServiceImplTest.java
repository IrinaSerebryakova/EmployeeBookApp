package com.employee.EmployeeBook;

import com.employee.EmployeeBook.exception.EmployeeAlreadyAddedException;
import com.employee.EmployeeBook.exception.EmployeeNotFoundException;
import com.employee.EmployeeBook.exception.IncorrectInputException;
import org.junit.jupiter.api.Test;

import static com.employee.EmployeeBook.EmployeeTestConstants.*;
import static org.apache.commons.lang3.StringUtils.*;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceImplTest {
    private final EmployeeServiceImpl testService = new EmployeeServiceImpl();
    @Test
    public void shouldAddEmployeeIfDoNotExist() {
        Employee actual = testService.put(LASTNAME, FIRSTNAME, DEP, SALARY);

        assertEquals(actual.getLastName(), LASTNAME);
        assertEquals(actual.getFirstName(), FIRSTNAME);
        assertEquals(actual.getDepartment(), DEP);
        assertEquals(actual.getSalary(), SALARY);
    }

    @Test
    public void shouldThrowIncorrectInputExceptionInCaseOfDepWithZeroNumber() {
        assertThrows(IncorrectInputException.class,
                () -> testService.put(LASTNAME, FIRSTNAME, NULL_INTEGER, SALARY));
    }

    @Test
    public void shouldThrowIncorrectInputExceptionInCaseOfDepWithNegativeNumber() {
        assertThrows(IncorrectInputException.class,
                () -> testService.put(LASTNAME, FIRSTNAME, NEGATIVE_INTEGER, SALARY));
    }
    @Test
    public void shouldThrowIncorrectInputExceptionInCaseOfSalaryWithZeroNumber() {
        assertThrows(IncorrectInputException.class,
                () -> testService.put(LASTNAME, FIRSTNAME, DEP, NULL_INTEGER));
    }

    @Test
    public void shouldThrowIncorrectInputExceptionInCaseOfSalaryWithNegativeNumber() {
        assertThrows(IncorrectInputException.class,
                () -> testService.put(LASTNAME, FIRSTNAME, DEP, NEGATIVE_INTEGER));
    }

    @Test
    public void shouldAddEmployeeWithNonCorrectName() {
        Employee actual = testService.put(WRONG_TYPE, WRONG_TYPE, DEP, SALARY);

        assertEquals(actual.getLastName(), capitalize(lowerCase(WRONG_TYPE)));
        assertEquals(actual.getFirstName(), capitalize(lowerCase(WRONG_TYPE)));
        assertEquals(actual.getDepartment(), DEP);
        assertEquals(actual.getSalary(), SALARY);
    }

    @Test
    public void tryAddEmployeeAlreadyExistAndGetEmployeeAlreadyAddedException() {
        assertThrows(EmployeeAlreadyAddedException.class,
                () -> testService.put(LASTNAME, FIRSTNAME, DEP, SALARY));
    }

    @Test
    public void tryAddEmployeeWithNullOrWrongStringNameShouldThrowIncorrectInputException() {
        assertThrows(IncorrectInputException.class,
                () -> testService.put(WRONG_STRING, NULL_STRING, DEP, SALARY));
    }

    @Test
    public void tryRemoveNotExistEmployeeShouldThrowEmployeeNotFoundException() {
        assertThrows(EmployeeNotFoundException.class,
                () -> testService.remove("Сухоруков", "Вячеслав"));
    }

    @Test
    public void removeExistEmployeeAndGetReturnRemovingEmployee() {
       Employee remove = testService.remove(LASTNAME, FIRSTNAME);

        assertEquals(remove.getLastName(), LASTNAME);
        assertEquals(remove.getFirstName(), FIRSTNAME);
        assertEquals(remove.getDepartment(), DEP);
        assertEquals(remove.getSalary(), SALARY);
    }
}