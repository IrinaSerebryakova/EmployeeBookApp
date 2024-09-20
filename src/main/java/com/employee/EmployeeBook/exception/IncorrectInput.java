package com.employee.EmployeeBook.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IncorrectInput extends RuntimeException{
 public IncorrectInput(String message) {
        super(message);
    }
}

