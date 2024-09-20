package com.employee.EmployeeBook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (HttpStatus.CONFLICT)
public class ArrayIsFull extends RuntimeException{
     public ArrayIsFull(String message) {
        super(message);
    }
}
