package com.brickred.employeeapp.repository;

import com.brickred.employeeapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query("SELECT e FROM Employee e WHERE e.name=: name")
    List<Employee> getbyName(String name);

    @Query("SELECT e FROM Employee e WHERE e.name = :name AND e.address.city = :city")
     Employee findByNameAndCity(String name, String city);
}
