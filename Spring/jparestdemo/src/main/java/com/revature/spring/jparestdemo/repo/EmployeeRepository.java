package com.revature.spring.jparestdemo.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.spring.jparestdemo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    List<Employee> findByName(String name);
    List<Employee> findByNameAndDepartment(String name, String department);

    @Query("Select e from Employee e where e.department = :dept")
     List<Employee> findByDepartment(@Param("dept") String department);

}
