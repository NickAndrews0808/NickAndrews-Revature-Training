package com.revature.spring.jparestdemo.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.revature.spring.jparestdemo.model.Employee;
import com.revature.spring.jparestdemo.service.EmployeeService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    
    @GetMapping("/employee/{id}")
    public Employee getEmployee(@RequestParam Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("employee/delete/{id}")
    public void deleteEmployee(@RequestParam Long id) {
        employeeService.deleteEmployee(id);
    }
    
    @PostMapping("employee/update/{id}")
    public Employee updateEmployee(@Valid@RequestBody Employee employee, @RequestParam Long id) {
        Employee existingEmployee = employeeService.getEmployeeById(id);
        if (existingEmployee != null) {
            existingEmployee.setName(employee.getName());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setDepartment(employee.getDepartment());
            return employeeService.createEmployee(existingEmployee);
        }
        return null; // Or throw an exception if preferred
    }
    
    
}
