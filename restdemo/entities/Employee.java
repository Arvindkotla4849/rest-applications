package com.example.restdemo.entities;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.annotation.Generated;
import javax.print.attribute.standard.Severity;
import javax.validation.constraints.*;


public class Employee
{
    @GeneratedValue
    private int id;
    @NotEmpty
    @Size(min=5,message = "first name should not be null")
    private String firstname;
    @NotEmpty
    @Size(min=5,message = "last name should not be null")
    private String lastname;
    @Size(min=2,max=50)
    @Email(message = "The format is like this",regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
    @NotNull(message = "email id is not valid")
    private String emailid;
    @NotNull(message = "mobile number is not correct")
    private long mobileno;


    public Employee(){
    }

    public Employee(int id, String firstname, String lastname, String emailid, long mobileno) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailid = emailid;
        this.mobileno = mobileno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public long getMobileno() {
        return mobileno;
    }

    public void setMobileno(long mobileno) {
        this.mobileno = mobileno;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", emailid='" + emailid + '\'' +
                ", mobileno=" + mobileno +
                '}';
    }

    public static void add(Employee employee) {
    }
}
