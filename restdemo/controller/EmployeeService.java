package com.example.restdemo.controller;

import com.example.restdemo.Exceptions.DuplicateFound;
import com.example.restdemo.entities.Employee;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeService
{
    public static Connection con = DBconnection.getcon();
    public Employee createEmp(Employee employee)
    {
        try{

            PreparedStatement preparedStatement=con.prepareStatement("insert into employee(firstname,lastname,emailid,mobileno) values (?,?,?,?)");
            //preparedStatement.setInt(1,employee.getId());
            preparedStatement.setString(1,employee.getFirstname());
            preparedStatement.setString(2,employee.getLastname());
            preparedStatement.setString(3,employee.getEmailid());
            preparedStatement.setLong(4,employee.getMobileno());
            int key= preparedStatement.executeUpdate();

            System.out.println(key);

            if(key==1){
               return  employee;
            }
            else {
                return null;
            }
        }
        catch (SQLException e) {

            throw new DuplicateFound("Duplicate emailId is not valid here");
            //e.printStackTrace();
        }
    }


    public List<Employee> employeeGet()
    {

        List<Employee> employeeList= new ArrayList<>();
        try {
            PreparedStatement preparedStatement = con.prepareStatement("select * from employee");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next())
            {
                Employee employee1= new Employee(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getString(4),
                        (int) rs.getLong(5));

                if (!(employeeList.contains(employee1)))
                {
                    // List<Employee> employeelist = null;
                    employeeList.add(employee1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }


    public Employee getById(int id)
    {

        try {
            PreparedStatement preparedStatement = con.prepareStatement("select * from employee where id=? ");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
               Employee employee=new Employee(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),
                        resultSet.getString(4),resultSet.getLong(5));

                return employee;
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<Employee> deleteEmployee(int id)
    {
        try {

            PreparedStatement ps =con.prepareStatement("delete from employee where id=?");
            ps.setInt(1, id);
            ps.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Employee updateString( Employee employee)
    {
        try {

            PreparedStatement preparedStatement = con.prepareStatement("update employee set firstname=? ,lastname=? where id=?");
            preparedStatement.setString(1,employee.getFirstname());
            preparedStatement.setString(2,employee.getLastname());
            preparedStatement.setInt(3,employee.getId());
            int key=preparedStatement.executeUpdate();
            if(key==1){
                System.out.println("updated successfully");
            }
            else {
                System.out.println("not updated");
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
