package com.brickred.employeeapp.service;

import com.brickred.employeeapp.dto.ProjectAssignDto;
import com.brickred.employeeapp.exception.EmployeeException;
import com.brickred.employeeapp.model.Employee;
import com.brickred.employeeapp.model.ProjectAssign;
import com.brickred.employeeapp.repository.EmployeeRepository;
import com.brickred.employeeapp.repository.ProjectAssignRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ProjectAssignServiceImpl {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public  void assignProject(ProjectAssignDto projectAssignDto) throws EmployeeException{
        if(projectAssignDto != null) {
            //employee from employeeDTo
            ProjectAssign projectAssign = ProjectAssign.builder;

//
            //saving employee to DB in Employee table
            ProjectAssignRepo.save(projectAssign);
            //success message

        }
        else{
            //throw exception
            throw new EmployeeException("Please give proper input");
        }
    }
    }

