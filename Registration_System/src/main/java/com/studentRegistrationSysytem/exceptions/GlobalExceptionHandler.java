package com.studentRegistrationSysytem.exceptions;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<MyErrorClass1> getException(MethodArgumentNotValidException e, WebRequest req) {

        MyErrorClass1 e1 = new MyErrorClass1();
        List<String> errors = e.getBindingResult().getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        e1.setMessage(errors);
        e1.setLocalDateTimes(LocalDateTime.now());
        e1.setDescption(req.getDescription(false));

        return new ResponseEntity<MyErrorClass1>(e1, HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<MyErrorClass> getException(NoHandlerFoundException e, WebRequest req) {

        MyErrorClass e1 = new MyErrorClass();
        e1.setMessage("Invalid url , Or Handle Not found....");
        e1.setLocalDateTimes(LocalDateTime.now());
        e1.setDescption(req.getDescription(false));

        return new ResponseEntity<MyErrorClass>(e1, HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(DataBaseError.class)
    public ResponseEntity<MyErrorClass> getException(DataBaseError e, WebRequest req) {

        MyErrorClass e1 = new MyErrorClass();
        e1.setMessage(e.getMessage());
        e1.setLocalDateTimes(LocalDateTime.now());
        e1.setDescption(req.getDescription(false));

        return new ResponseEntity<MyErrorClass>(e1, HttpStatus.BAD_GATEWAY);

    }
    @ExceptionHandler(ResourcesNotFoundException.class)
    public ResponseEntity<MyErrorClass> getException(ResourcesNotFoundException e, WebRequest req) {

        MyErrorClass e1 = new MyErrorClass();
        e1.setMessage(e.getMessage());
        e1.setLocalDateTimes(LocalDateTime.now());
        e1.setDescption(req.getDescription(false));

        return new ResponseEntity<MyErrorClass>(e1, HttpStatus.BAD_GATEWAY);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorClass> getException(Exception e, WebRequest req) {

        MyErrorClass e1 = new MyErrorClass();
        e1.setMessage(e.getMessage());
        e1.setLocalDateTimes(LocalDateTime.now());
        e1.setDescption(req.getDescription(false));

        return new ResponseEntity<MyErrorClass>(e1, HttpStatus.BAD_GATEWAY);

    }
}
