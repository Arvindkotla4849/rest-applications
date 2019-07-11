package com.example.restdemo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection
{

    private static Connection con;
    static{
        try{
             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");

        }

          catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public static Connection getcon()
    {
        return con;
    }
}
