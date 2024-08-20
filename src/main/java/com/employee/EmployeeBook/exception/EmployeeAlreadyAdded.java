package com.employee.EmployeeBook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (HttpStatus.BAD_REQUEST)
public class EmployeeAlreadyAdded extends RuntimeException{

    public EmployeeAlreadyAdded(String message) {
        super(message);
    }
}
