package com.revature.spring.jparestdemo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.revature.spring.jparestdemo.model.Employee;
import com.revature.spring.jparestdemo.repo.EmployeeRepository;
import jakarta.transaction.Transactional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> getEmployee(String name) {
        // Use property expression or derived query method in EmployeeRepository
        return employeeRepository.findByName(name);
    }

    @Transactional
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> getEmployeesByNameAndDepartment(String name, String department) {
        return employeeRepository.findByNameAndDepartment(name, department);
    }

    @Transactional
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        return employeeRepository.findById(id).map(employee -> {
            employee.setName(updatedEmployee.getName());
            employee.setEmail(updatedEmployee.getEmail());
            employee.setDepartment(updatedEmployee.getDepartment());
            return employeeRepository.save(employee);
        }).orElse(null);
    }
}
