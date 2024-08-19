package com.employee.EmployeeBook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (code = HttpStatus.CONFLICT)
public class EmployeeAlreadyAdded extends Exception{
    public EmployeeAlreadyAdded(String message) {
        super(message);
    }
}
