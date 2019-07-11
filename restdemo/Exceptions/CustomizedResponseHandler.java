package com.example.restdemo.Exceptions;


import com.example.restdemo.entities.Employee;
import org.springframework.cglib.core.DuplicatesPredicate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.Valid;
import java.net.URI;
import java.security.Provider;
import java.util.Date;

@ControllerAdvice
public class CustomizedResponseHandler extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<Object> handleEntityNotFound(UserNotFound exception, WebRequest request)
    {
        String date = new Date().toString();
        ExceptionResponse exceptionResponse = new ExceptionResponse(date, exception.getMessage(), request.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request)
    {
        String date=new Date().toString();
        ExceptionResponse exceptionResponse=new ExceptionResponse( date,ex.getMessage(),request.getDescription(false));
        return  new ResponseEntity(exceptionResponse ,HttpStatus.INTERNAL_SERVER_ERROR);

    }
     @ExceptionHandler(DuplicateFound.class)
     public ResponseEntity<Object> handleEntityFound(DuplicateFound duplicateFound,WebRequest request){
        String date=new Date().toString();
        ExceptionResponse exceptionResponse=new ExceptionResponse(date, duplicateFound.getMessage(),request.getDescription(false));
        return new ResponseEntity(exceptionResponse ,HttpStatus.ALREADY_REPORTED);
     }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request)
    {
        String date=new Date().toString();
        ExceptionResponse response=new ExceptionResponse( date,ex.getMessage(),ex.getBindingResult().getFieldError().getDefaultMessage());
        response.setMessage("First name and last name should not be null");
        return new ResponseEntity(response,HttpStatus.BAD_REQUEST);
    }

}