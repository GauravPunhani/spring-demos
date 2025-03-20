package com.example.service1.service;

import com.example.service1.annotation.LogExecutionTime;
import com.example.service1.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {
    @LogExecutionTime
    public List<Employee> getEmployees() {
        Employee e = new Employee();
        e.setAge(23);
        e.setName("Suresh");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        return Arrays.asList(e);
    }
}
