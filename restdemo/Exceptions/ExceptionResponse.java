package com.example.restdemo.Exceptions;

import java.util.Date;

public class ExceptionResponse
{
    private String timeStamp;
    private String message;
    private String details;

    public ExceptionResponse(int i, String s)
    {

    }

    public ExceptionResponse(String timeStamp, String message, String details) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }

    public String getTimeStamp() {
        return this.timeStamp;
    }

    public String getMessage() {
        return this.message;
    }

    public String getDetails() {
        return this.details;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "ExceptionResponse{" +
                "timeStamp=" + timeStamp +
                ", message='" + message + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
