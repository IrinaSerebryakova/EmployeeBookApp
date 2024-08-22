package com.employee.EmployeeBook;

import java.util.Objects;

public class Employee {
    private String fullName;
    private int value;


    public Employee(String fullName, int value) {
        this.fullName = fullName;
        this.value = value;
    }

    public String getFullName() {
        return fullName;
    }


    public int getValue() {
        return value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return value == employee.value && Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, value);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", value=" + value +
                '}';
    }
}
