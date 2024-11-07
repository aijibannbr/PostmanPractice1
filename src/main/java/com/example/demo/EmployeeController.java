package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import java.io.File;
import java.io.IOException;
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @PostMapping("/add")
    public String addEmployee(@RequestBody Employee employee) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("employee.json"), employee);
            return "Employee data saved successfully!";
        } catch (IOException e) {
            return "Error saving employee data: " + e.getMessage();
        }
    }
}

