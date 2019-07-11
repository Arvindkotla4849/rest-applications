package com.example.restdemo.JdbcTemplate;

import com.example.restdemo.entities.Employee;

import javax.sql.DataSource;
import java.util.List;

public interface EmployeeInterface
{
    public default void setDataSource(DataSource dataSource) {

    }

    public default List<Employee> ListEmployee()
    {
        return null;
    }
}
