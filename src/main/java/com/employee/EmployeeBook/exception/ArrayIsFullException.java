package com.employee.EmployeeBook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ArrayIsFullException extends RuntimeException {
    public ArrayIsFullException(String message) {
        super(message);
    }
}
