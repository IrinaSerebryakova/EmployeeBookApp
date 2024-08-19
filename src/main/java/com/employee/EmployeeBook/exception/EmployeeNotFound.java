package com.employee.EmployeeBook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (code = HttpStatus.CONFLICT)
public class EmployeeNotFound extends Exception{
    public EmployeeNotFound(String message) {
        super(message);
    }
}
