package com.employee.EmployeeBook;

import java.util.Objects;

public class Employee {
    private String fullName;
    private int department;
    private double salary;

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }


    public Employee(int department, double salary) {
        this.department = department;
        this.salary = salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, department, salary);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return department == employee.department && Double.compare(employee.salary, salary) == 0 && Objects.equals(fullName, employee.fullName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }
}
