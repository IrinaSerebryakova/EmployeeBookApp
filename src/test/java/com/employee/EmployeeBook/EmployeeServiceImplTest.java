package com.employee.EmployeeBook;

import com.employee.EmployeeBook.exception.EmployeeAlreadyAdded;
import com.employee.EmployeeBook.exception.IncorrectInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.*;
import static org.apache.commons.lang3.StringUtils.isNumeric;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceImplTest {
    private Map<String, Employee> employees;
    private Employee employee;
    private List<Employee> employeesWrongData = new ArrayList<>();
    private List<Employee> employeesIncorrectInput = new ArrayList<>();
    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

    @BeforeEach
    public void setUp() {
        employees = new HashMap<>(Map.of(
                "Пугачёва Алла", new Employee("Пугачёва", "Алла", 1, 465000),
                "Киркоров Филипп", new Employee("Киркоров", "Филипп", 1, 455000),
                "Козлов Игорь", new Employee("Козлов", "Игорь", 2, 225000),
                "Козлов Иван", new Employee("Козлов", "Иван", 2, 125000),
                "Бронина Виктория", new Employee("Бронина", "Виктория", 2, 120000),
                "Козлов Святослав", new Employee("Козлов", "Святослав", 3, 156000),
                "Восточная Марина", new Employee("Восточная", "Марина", 4, 110000),
                "Васильева Эльвира", new Employee("Васильева", "Эльвира", 5, 75000),
                "Сухорукова Светлана", new Employee("Сухорукова", "Светлана", 4, 138000)
        ));


        Employee employeeForTests1 = new Employee("вЕрНоПоДдАнНый", "бОрИс", 4, 50000);
        Employee employeeForTests2 = new Employee("спокойный", "борис", 4, 50000);

        employeesIncorrectInput.add(employeeForTests1);
        employeesIncorrectInput.add(employeeForTests2);

        Employee wrongData1 = new Employee(null, "Борис", 4, 50000);
        Employee wrongData2 = new Employee("Верный", null, 4, 50000);
        Employee wrongData3 = new Employee("верный", "Борис", 0, 50000);
        Employee wrongData4 = new Employee("вЕрнЫй", "борис", 8, 0);
        Employee wrongData5 = new Employee(" ", "борис", 8, 50000);
        Employee wrongData6 = new Employee("Козлов", " ", 8, 50000);
        Employee wrongData7 = new Employee("вЕрнЫй", "борис", -1, 0);
        Employee wrongData8 = new Employee("вЕрнЫй", "борис", 8, -10000);
        Employee wrongData9 = new Employee("afvymrsy", "имя", 2, 10000);
        Employee wrongData10 = new Employee("фамилия", "аитэжьlfnasdfvn", 2, 10000);

        employeesWrongData.add(wrongData1);
        employeesWrongData.add(wrongData2);
        employeesWrongData.add(wrongData3);
        employeesWrongData.add(wrongData4);
        employeesWrongData.add(wrongData5);
        employeesWrongData.add(wrongData6);
        employeesWrongData.add(wrongData7);
        employeesWrongData.add(wrongData8);
        employeesWrongData.add(wrongData9);
        employeesWrongData.add(wrongData10);
    }

    @Test
    public void checkAddEmployeeCorrectly() {
        employee = new Employee("Сухоруков", "Вячеслав", 2, 120000);
        employees.put("Сухоруков Вячеслав", employee);
        boolean actualIfEmployeeYetNotAdded = false;
        boolean expectedIfEmployeeYetNotAdded = true;

        if (!employee.equals(employees.values().stream()
                .filter(e -> e.getLastName().equals("Сухоруков"))
                .filter(e -> e.getFirstName().equals("Вячеслав"))
                .filter(e -> e.getDepartment() == 2)
                .filter(e -> e.getSalary() == 120000)
        )) {
            actualIfEmployeeYetNotAdded = true;
        }

        assertEquals(expectedIfEmployeeYetNotAdded, actualIfEmployeeYetNotAdded);
        assertTrue(employees.containsKey("Сухоруков Вячеслав"));
        assertTrue(employees.containsValue(employee));
        assertEquals(employee, employees.get("Сухоруков Вячеслав"));
    }


    @Test
    public void testThrowingExceptionEmployeeAlreadyAdded() {
        Throwable exception = assertThrows(
                RuntimeException.class,
                () -> {
                    throw new EmployeeAlreadyAdded("Сотрудник уже существует");
                }
        );
        assertEquals("Сотрудник уже существует", exception.getMessage());
    }

    @Test
    public void testThrowingExceptionIncorrectInput() {
        Throwable exception = assertThrows(
                RuntimeException.class,
                () -> {
                    throw new IncorrectInput("Неправильный ввод имени");
                }
        );
        assertEquals("Неправильный ввод имени", exception.getMessage());
    }

    @Test
    public void testFixErrorsInCaseOfIncorrectInputName() {
        Employee employeeForTests1 = new Employee("вЕрНоПоДдАнНый", "бОрИс", 4, 50000);
        Employee employeeForTests2 = new Employee("спокойный", "борис", 4, 50000);
        boolean correctData1 = false;
        boolean correctData2 = false;

        String lastName = employeeService.checkAndCorrectName(employeeForTests1.getLastName());
        String firstName = employeeService.checkAndCorrectName(employeeForTests1.getFirstName());
        String fullName = lastName + " " + firstName;
        employeeService.checkNumber(employeeForTests1.getDepartment());
        employeeService.checkNumber(employeeForTests1.getSalary());
        if (!employees.containsKey(fullName)) {
            Employee newEmployee = new Employee(lastName, firstName, employeeForTests1.getDepartment(), employeeForTests1.getSalary());
            employees.put(fullName, newEmployee);
            correctData1 = true;
        }

        lastName = employeeService.checkAndCorrectName(employeeForTests2.getLastName());
        firstName = employeeService.checkAndCorrectName(employeeForTests2.getFirstName());
        fullName = lastName + " " + firstName;
        employeeService.checkNumber(employeeForTests2.getDepartment());
        employeeService.checkNumber(employeeForTests2.getSalary());
        if (!employees.containsKey(fullName)) {
            Employee newEmployee = new Employee(lastName, firstName, employeeForTests2.getDepartment(), employeeForTests2.getSalary());
            employees.put(fullName, newEmployee);
            correctData2 = true;
        }

        assertTrue(correctData1);
        assertTrue(correctData2);
    }

    @Test
    public void testNameIsAlphaAndCapitalizeName() {
        Employee employeeForTests1 = new Employee("вЕрНоПоДдАнНый", "бОрИс", 4, 50000);
        Employee employeeForTests2 = new Employee("спокойный", "борис", 4, 50000);
        String fullName1;
        String fullName2;
        boolean isAlpha1 = false;
        boolean isAlpha2 = false;

        if (isAlpha(employeeForTests1.getLastName()) || isAlpha(employeeForTests1.getFirstName())) {
            isAlpha1 = true;
        }
        String lastName1 = capitalize(lowerCase(employeeForTests1.getLastName()));
        String firstName1 = capitalize(lowerCase(employeeForTests1.getFirstName()));
        fullName1 = lastName1 + " " + firstName1;

        if (isAlpha(employeeForTests2.getLastName()) || isAlpha(employeeForTests2.getFirstName())) {
            isAlpha2 = true;
        }
        String lastName2 = capitalize(lowerCase(employeeForTests2.getLastName()));
        String firstName2 = capitalize(lowerCase(employeeForTests2.getFirstName()));
        fullName2 = lastName2 + " " + firstName2;

        assertTrue(isAlpha1);
        assertTrue(isAlpha2);
        assertEquals("Верноподданный Борис", fullName1);
        assertEquals("Спокойный Борис", fullName2);
    }


    @Test
    public void testForCheckingNumber() {
        Employee employeeForTests1 = new Employee("вЕрНоПоДдАнНый", "бОрИс", 4, 50000);
        Employee employeeForTests2 = new Employee("спокойный", "борис", 4, 50000);

        boolean isNumeric1 = false;
        boolean isNumeric2 = false;

        if (isNumeric(Integer.toString(employeeForTests1.getDepartment())) || isNumeric(Integer.toString(employeeForTests1.getSalary()))) {
            isNumeric1 = true;
        }

        if (isNumeric(Integer.toString(employeeForTests2.getDepartment())) || isNumeric(Integer.toString(employeeForTests2.getSalary()))) {
            isNumeric2 = true;
        }

        assertTrue(isNumeric1);
        assertTrue(isNumeric2);
    }

    @Test
    public void testFixErrorsInCaseOfInputWrongData() {
        boolean[] errorsActual = {true, true, true, true, true, true, true, true, true, true};
        boolean[] errorsExpected = {false, false, false, false, false, false, false, false, false, false};
        int counter = 0;
        for (Employee e : employeesWrongData) {
            try {
                String fullName = employees.get(counter).getLastName() + " " + employees.get(counter).getFirstName();
                if (!employees.containsKey(fullName)) {
                    Employee newEmployee = new Employee(employees.get(counter).getLastName(),
                            employees.get(counter).getFirstName(),
                            employees.get(counter).getDepartment(),
                            employees.get(counter).getSalary());
                    employees.put(fullName, newEmployee);
                }
            } catch (NullPointerException ex) {
                errorsActual[counter] = false;
                counter++;
            } catch (IncorrectInput ex) {
                errorsActual[counter] = false;
                counter++;
            }
        }
        assertTrue(Arrays.equals(errorsExpected, errorsActual));
    }


    @Test
    public void checkCorrectRemovingOfExistEmployee() {

        Employee exist = new Employee("Сухорукова", "Светлана", 4, 138000);
        exist.setLastName(employeeService.checkAndCorrectName(exist.getLastName()));
        exist.setFirstName(employeeService.checkAndCorrectName(exist.getFirstName()));
        String fullName = exist.getLastName() + " " + exist.getFirstName();
        if (employees.containsKey(fullName)) {
            employees.remove(fullName);
        }

        assertTrue(!employees.containsKey(fullName));
    }

    @Test
    public void checkCorrectWorkingInProcessRemovingOfNoExistEmployee() {
        Employee noExist = new Employee("спокойный", "борис", 4, 50000);
        boolean catchOfEmployeeNotFoundException = false;
        if (!employees.containsKey(noExist.getLastName() + " " + noExist.getFirstName())) {
            catchOfEmployeeNotFoundException = true;
        }

        assertTrue(!employees.containsKey(noExist.getLastName() + " " + noExist.getFirstName()));
        assertTrue(catchOfEmployeeNotFoundException == true);
    }


    @Test
    public void checkFindEmployeeInTheList() {
        String key1 = "Сухорукова Светлана";
        String key2 = "Cпокойный Борис";
        assertTrue(employees.containsKey(key1));
        assertTrue(!employees.containsKey(key2));
    }
}
