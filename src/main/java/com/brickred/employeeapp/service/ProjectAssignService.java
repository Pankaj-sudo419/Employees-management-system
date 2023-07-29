package com.brickred.employeeapp.service;

import com.brickred.employeeapp.dto.ProjectAssignDto;
import com.brickred.employeeapp.exception.EmployeeException;

public interface ProjectAssignService {
     public void  assignProject(ProjectAssignDto projectAssignDto) throws EmployeeException;
}
