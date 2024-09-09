package com.employee.EmployeeBook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (HttpStatus.ALREADY_REPORTED)

public class EmployeeAlreadyAdded extends RuntimeException{


    public EmployeeAlreadyAdded(String message) {
        super(message);
    }
}
