package com.example.restdemo.JdbcTemplate;

import com.example.restdemo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class EmployeeMapper
{
    @Autowired
   public JdbcTemplate jdbcTemplate;


    public List<Employee> ListEmployee() {

        List<Employee>employees=new ArrayList<>();
        String SQL="select * from employee";
         employees=jdbcTemplate.query(SQL,new BeanPropertyRowMapper<>(Employee.class));
        return employees;
    }
}
