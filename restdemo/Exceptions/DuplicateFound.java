package com.example.restdemo.Exceptions;

public class DuplicateFound extends RuntimeException
{
    public DuplicateFound(String message){
        super(message);
    }

}
