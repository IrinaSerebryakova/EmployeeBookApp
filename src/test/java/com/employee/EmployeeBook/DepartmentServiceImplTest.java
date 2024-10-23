package com.employee.EmployeeBook;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static com.employee.EmployeeBook.EmployeeTestConstants.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {
    @Mock
    private EmployeeService employeeServiceMock;
   @InjectMocks
    private DepartmentService departmentServiceMock = mock(DepartmentService.class);

    @Test
    public void shouldFindEmployeeWithMaxSalaryInDep() {
       when(departmentServiceMock.findEmployeeWithMaxSalary(DEP))
               .thenReturn(MAX_SALARY_EMPLOYEE);
       assertEquals(MAX_SALARY_EMPLOYEE, departmentServiceMock.findEmployeeWithMaxSalary(DEP));
       verify(departmentServiceMock, atLeast(1)).findEmployeeWithMaxSalary(DEP);
    }
    @Test
    public void shouldFindEmployeeWithMinSalaryInDep() {
        when(departmentServiceMock.findEmployeeWithMinSalary(DEP)).thenReturn(MIN_SALARY_EMPLOYEE);
        assertEquals(MIN_SALARY_EMPLOYEE, departmentServiceMock.findEmployeeWithMinSalary(DEP));
        verify(departmentServiceMock, atLeast(1)).findEmployeeWithMinSalary(DEP);
    }
    @Test
    public void shouldFindEmployeesByDepartments() {
        when(departmentServiceMock.findEmployeesByDepartments())
                .thenReturn(employeesByDepartments);
        assertEquals(departmentServiceMock.findEmployeesByDepartments(), employeesByDepartments);
        verify(departmentServiceMock, atLeast(1)).findEmployeesByDepartments();
    }

    @Test
    public void shouldFindEmployeesByDepartment() {
        when(departmentServiceMock.findEmployeesByDepartment(DEP))
                .thenReturn(secondDepartment);
        assertEquals(departmentServiceMock.findEmployeesByDepartment(DEP), secondDepartment);
        verify(departmentServiceMock, atLeast(1)).findEmployeesByDepartment(DEP);
    }

    @Test
    public void shouldReturnEmptyListWhenDepartmentDoNotExist() {
        when(departmentServiceMock.findEmployeesByDepartment(NEGATIVE_INTEGER))
                .thenReturn(EMPTY_LIST);
        assertEquals(EMPTY_LIST, departmentServiceMock.findEmployeesByDepartment(NEGATIVE_INTEGER));
    }
}
