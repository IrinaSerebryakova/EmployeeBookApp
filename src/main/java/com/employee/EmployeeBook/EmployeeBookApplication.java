package com.employee.EmployeeBook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.employee.EmployeeBook.exception.ArrayIsFull;
import com.employee.EmployeeBook.exception.EmployeeAlreadyAdded;
import com.employee.EmployeeBook.exception.EmployeeNotFound;

@SpringBootApplication
public class EmployeeBookApplication {
	public static void main(String[] args){
		SpringApplication.run(EmployeeBookApplication.class, args);
	}
}

