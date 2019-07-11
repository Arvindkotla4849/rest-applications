package com.example.restdemo.JdbcTemplate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


/*
@EntityScan("com.example.restdemo.JdbcTemplate")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
*/
@Configuration
public class EmployeeJDBCTemplate  {


    @Bean
    public DataSource getDataSource()
    {
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/employee");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        return dataSource;
    }


    @Bean
    public JdbcTemplate setJdbcTemplate(){

        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource());
        return jdbcTemplate;
    }


  /*  @Deprecated
    @GetMapping("/emp/get")
    public List<Employee> ListEmployee() {

        String SQL="select * from employee";
        List<Employee> employees=jdbcTemplate.query(SQL,new BeanPropertyRowMapper<Employee>());
        return employees;
    }*/
}
