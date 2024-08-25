package com.employee.EmployeeBook;

import java.util.Objects;
import static org.apache.commons.lang3.StringUtils.capitalize;


public class Employee {
    private final String firstName;
    private final String lastName;
    private int department;
    private double salary;

    public Employee(String lastName, String firstName,  int department, double salary) {
        this.firstName = capitalize(firstName);
        this.lastName = capitalize(lastName);
        this.department = department;
        this.salary = salary;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && Double.compare(employee.salary, salary) == 0 && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, department, salary);
    }

    @Override
    public String toString() {
        return "Employee: " +
                " lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}' + "\n";
    }

}

