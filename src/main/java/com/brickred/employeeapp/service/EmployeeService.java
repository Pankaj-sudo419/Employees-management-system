package com.brickred.employeeapp.service;

import com.brickred.employeeapp.dto.EmployeeDto;
import com.brickred.employeeapp.exception.EmployeeException;
import com.brickred.employeeapp.model.Employee;

import java.util.List;


public interface EmployeeService {
    public void registerEmployee(EmployeeDto employeeDto) throws EmployeeException;
    public Employee getbyId(Integer id) throws EmployeeException;
    public List<Employee> getallMember() throws EmployeeException;
    public Employee deleteEmployeebyID(Integer id)throws EmployeeException;
    public Employee updateEmployeeDetails(Employee employee)throws EmployeeException;

}
