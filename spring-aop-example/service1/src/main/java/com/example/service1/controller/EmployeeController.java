package com.example.service1.controller;

import com.example.service1.annotation.LogExecutionTime;
import com.example.service1.model.Employee;
import com.example.service1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }
    @GetMapping("/health")
    @ResponseBody
    public String healthCheck(){
        return "OK";
    }
}
