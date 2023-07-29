package com.brickred.employeeapp.repository;

import com.brickred.employeeapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProjectAssignRepo extends JpaRepository<ProjectAssignRepo,Integer> {


}
