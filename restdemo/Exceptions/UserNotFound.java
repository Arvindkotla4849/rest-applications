package com.example.restdemo.Exceptions;

public class UserNotFound extends RuntimeException
{
   public UserNotFound(String message){

        super(message);
    }

}
