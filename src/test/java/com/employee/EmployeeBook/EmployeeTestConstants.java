package com.employee.EmployeeBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeTestConstants {
        public static final String LASTNAME = "Сухоруков";
        public static final String FIRSTNAME = "Вячеслав";
        public static final String WRONG_TYPE = "сУхоРуКов";
        public static final int SALARY = 120000;
        public static final int MINSALARY = 10000;
        public static final int DEP = 2;

        public static final String WRONG_STRING = "afvymrsy";
        public static final int NEGATIVE_INTEGER = -1;
        public static final String NULL_STRING = null;
        public static final int NULL_INTEGER = 0;

        public static final Employee MAX_SALARY_EMPLOYEE = new Employee(LASTNAME,FIRSTNAME,DEP,SALARY);
        public static final Employee MIN_SALARY_EMPLOYEE = new Employee("Бронина","Виктория", DEP, MINSALARY);
        public static final List<Employee> secondDepartment = List.of(MAX_SALARY_EMPLOYEE,MIN_SALARY_EMPLOYEE);
        public static final Map<Integer,List <Employee>> employeesByDepartments = Map.of(DEP,secondDepartment);
        public static final List<Employee> EMPTY_LIST = new ArrayList<>();
}