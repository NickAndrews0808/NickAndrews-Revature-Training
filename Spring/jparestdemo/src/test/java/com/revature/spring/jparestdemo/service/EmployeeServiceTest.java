package com.revature.spring.jparestdemo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.revature.spring.jparestdemo.model.Employee;
import com.revature.spring.jparestdemo.repo.EmployeeRepository;
import com.revature.spring.jparestdemo.service.EmployeeService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    private Employee createEmployee(Long id, String name, String email, String department) {
        Employee e = new Employee();
        e.setId(id);
        e.setName(name);
        e.setEmail(email);
        e.setDepartment(department);
        return e;
    }

    @Test
    void createEmployee_savesAndReturnsEmployee() {
        Employee input = createEmployee(null, "Alice", "alice@example.com", "Engineering");
        Employee saved = createEmployee(1L, "Alice", "alice@example.com", "Engineering");

        when(employeeRepository.save(input)).thenReturn(saved);

        Employee result = employeeService.createEmployee(input);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Alice", result.getName());
        verify(employeeRepository, times(1)).save(input);
    }

    @Test
    void getAllEmployees_returnsList() {
        Employee e1 = createEmployee(1L, "Bob", "bob@example.com", "HR");
        Employee e2 = createEmployee(2L, "Charlie", "charlie@example.com", "Sales");
        List<Employee> expected = Arrays.asList(e1, e2);

        when(employeeRepository.findAll()).thenReturn(expected);

        List<Employee> result = employeeService.getAllEmployees();

        assertEquals(2, result.size());
        assertEquals(expected, result);
        verify(employeeRepository, times(1)).findAll();
    }

    @Test
    void getEmployeeById_found_returnsEmployee() {
        Employee e = createEmployee(5L, "Dana", "dana@example.com", "Finance");

        when(employeeRepository.findById(5L)).thenReturn(Optional.of(e));

        Employee result = employeeService.getEmployeeById(5L);

        assertNotNull(result);
        assertEquals("Dana", result.getName());
        verify(employeeRepository, times(1)).findById(5L);
    }

    @Test
    void getEmployeeById_notFound_returnsNull() {
        when(employeeRepository.findById(100L)).thenReturn(Optional.empty());

        Employee result = employeeService.getEmployeeById(100L);

        assertNull(result);
        verify(employeeRepository, times(1)).findById(100L);
    }

    @Test
    void getEmployee_byName_returnsList() {
        Employee e = createEmployee(3L, "Eve", "eve@example.com", "Marketing");
        List<Employee> expected = Collections.singletonList(e);

        when(employeeRepository.findByName("Eve")).thenReturn(expected);

        List<Employee> result = employeeService.getEmployee("Eve");

        assertEquals(1, result.size());
        assertEquals(expected, result);
        verify(employeeRepository, times(1)).findByName("Eve");
    }

    @Test
    void deleteEmployee_delegatesToRepository() {
        Long id = 7L;
        doNothing().when(employeeRepository).deleteById(id);

        employeeService.deleteEmployee(id);

        verify(employeeRepository, times(1)).deleteById(id);
    }

    @Test
    void getEmployeesByNameAndDepartment_returnsList() {
        Employee e = createEmployee(9L, "Frank", "frank@example.com", "IT");
        List<Employee> expected = Collections.singletonList(e);

        when(employeeRepository.findByNameAndDepartment("Frank", "IT")).thenReturn(expected);

        List<Employee> result = employeeService.getEmployeesByNameAndDepartment("Frank", "IT");

        assertEquals(expected, result);
        verify(employeeRepository, times(1)).findByNameAndDepartment("Frank", "IT");
    }

    @Test
    void updateEmployee_found_updatesAndReturns() {
        Long id = 11L;
        Employee existing = createEmployee(id, "Grace", "old@example.com", "Ops");
        Employee updatedDto = createEmployee(null, "Grace Hopper", "grace.hopper@example.com", "R&D");
        Employee saved = createEmployee(id, "Grace Hopper", "grace.hopper@example.com", "R&D");

        when(employeeRepository.findById(id)).thenReturn(Optional.of(existing));
        when(employeeRepository.save(any(Employee.class))).thenReturn(saved);

        Employee result = employeeService.updateEmployee(id, updatedDto);

        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals("Grace Hopper", result.getName());
        assertEquals("grace.hopper@example.com", result.getEmail());
        assertEquals("R&D", result.getDepartment());
        verify(employeeRepository, times(1)).findById(id);
        verify(employeeRepository, times(1)).save(existing);
    }

    @Test
    void updateEmployee_notFound_returnsNull() {
        Long id = 99L;
        Employee updatedDto = createEmployee(null, "Henry", "henry@example.com", "Support");

        when(employeeRepository.findById(id)).thenReturn(Optional.empty());

        Employee result = employeeService.updateEmployee(id, updatedDto);

        assertNull(result);
        verify(employeeRepository, times(1)).findById(id);
        verify(employeeRepository, never()).save(any(Employee.class));
    }
}