package com.example.restdemo.controller;

import com.example.restdemo.Exceptions.UserNotFound;
import com.example.restdemo.JdbcTemplate.EmployeeMapper;
import com.example.restdemo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeRestController {

    @Autowired
    EmployeeService empser;

    @Autowired
    EmployeeMapper employeeMapper;

    @Deprecated
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFileHandler(@RequestParam("id") String id, @RequestParam("file") MultipartFile file ) throws IOException {
        if (!file.isEmpty()) {
            try {
                /*byte[] bytes = file.getBytes();
                // Creating the directory to store file
                String rootPath = System.getProperty("desktop.image");
                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists())
                    dir.mkdirs();*/
                // Create the file on server
                File serverFile = new File("C:\\Users\\aravi\\OneDrive\\Desktop\\New folder\\"+id+".jpg");
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(file.getBytes());
                stream.flush();
                stream.close();

                return null;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }


    @Deprecated
    @PostMapping("/employee")
    public Employee createEmployee(@Valid @RequestBody Employee employee)
    {
       Employee emp= empser.createEmp(employee);
       emp= (Employee) employeeMapper.ListEmployee();

       return emp;
    }

    @Deprecated
    @GetMapping("/employee")
    public List<Employee> EmployeeGet()
    {
        List<Employee> emplist=new ArrayList<>();
         emplist=employeeMapper.ListEmployee();
        return emplist;
    }

    @Deprecated
    @GetMapping("/employee/{id}")
    public Employee getById(@PathVariable int id)
    {
        Employee employee=empser.getById( id);
        employee= (Employee) employeeMapper.ListEmployee();
        if(employee==null){

            throw new UserNotFound("id is not found");
        }
        else {

            return employee;
        }
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable int id)
    {
       List<Employee> employee= empser.deleteEmployee(id);
       employee=employeeMapper.ListEmployee();
       return null;
    }

    @PutMapping("/employee")
    public String updateString(@Valid @RequestBody Employee employee){

        empser.updateString(employee);
        return null;

    }


}
