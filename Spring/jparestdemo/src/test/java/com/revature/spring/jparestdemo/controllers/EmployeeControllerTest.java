package com.revature.spring.jparestdemo.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.*;

import com.revature.spring.jparestdemo.model.Employee;
import com.revature.spring.jparestdemo.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import java.util.Arrays;

// Add static imports for post, get, status, content
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(controllers = EmployeeController.class)
@ActiveProfiles("test")
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
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
    @DisplayName("POST /employees -> 200 and returns saved employee JSON")
    void postEmployees_returnsSavedEmployee() throws Exception {
        Employee input = createEmployee(null, "Alice", "alice@example.com", "Engineering");
        Employee saved = createEmployee(1L, "Alice", "alice@example.com", "Engineering");

        when(employeeService.createEmployee(any(Employee.class))).thenReturn(saved);

        mockMvc.perform(post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(saved)));

        verify(employeeService, times(1)).createEmployee(any(Employee.class));
    }

    @Test
    @DisplayName("GET /employees -> 200 and returns list JSON")
    void getEmployees_returnsList() throws Exception {
        Employee e1 = createEmployee(1L, "Bob", "bob@example.com", "HR");
        Employee e2 = createEmployee(2L, "Charlie", "charlie@example.com", "Sales");

        when(employeeService.getAllEmployees()).thenReturn(Arrays.asList(e1, e2));

        mockMvc.perform(get("/employees").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(Arrays.asList(e1, e2))));

        verify(employeeService, times(1)).getAllEmployees();
    }

    @Test
    @DisplayName("POST /employees with invalid data -> 400")
    void postEmployees_invalidData_returnsBadRequest() throws Exception {
        // Create employee with invalid data: name too short (< 4 chars) and invalid email
        Employee input = createEmployee(null, "Bob", "not-an-email", "HR");

        mockMvc.perform(post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isBadRequest());

        // Service should never be called when validation fails
        verify(employeeService, never()).createEmployee(any());
    }
}
