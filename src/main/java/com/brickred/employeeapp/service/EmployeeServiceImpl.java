package com.brickred.employeeapp.service;

import com.brickred.employeeapp.dto.EmployeeDto;
import com.brickred.employeeapp.exception.EmployeeException;
import com.brickred.employeeapp.model.Employee;
import com.brickred.employeeapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void registerEmployee(EmployeeDto employeeDto) throws EmployeeException {
        if(employeeDto != null) {
            //employee from employeeDTo
            Employee employee = Employee.builder()
//                    .joiningDate(employeeDto.getJoiningDate())
                    .name(employeeDto.getName())
                    .mobile(employeeDto.getMobile())
                    .email(employeeDto.getEmail())
                    .address(employeeDto.getAddress())
                    .designation(employeeDto.getDesignation())
                    .department(employeeDto.getDepartment())
                    .build();
            //saving employee to DB in Employee table
            employeeRepository.save(employee);
            //success message

        }else{
            //throw exception
            throw new EmployeeException("Please give proper input");
        }
    }

    @Override
    public Employee getbyId(Integer id) throws EmployeeException {
        return employeeRepository.findById(id).orElseThrow(()
                -> new EmployeeException("Member does not exist with name :" + id));
//      if(id !=null) {
//          return employeeRepository.findById(id);
//      }else{
//        throw   new EmployeeException("Member does not exist with name :" + id);
//      }
    }


    @Override
    public List<Employee> getallMember() throws EmployeeException {
        return employeeRepository.findAll();
    }

    @Override
    public Employee deleteEmployeebyID(Integer id) throws EmployeeException {
        Optional<Employee> opt = employeeRepository.findById(id);
        if (opt.isPresent()) {
           Employee existingEmployee = opt.get();
            employeeRepository.delete(existingEmployee);
            return existingEmployee;
        } else
            throw new EmployeeException("Employee does not exist with name :" + id);
    }


    @Override
    public Employee updateEmployeeDetails(Employee employee) throws EmployeeException {
        Optional<Employee> opt = employeeRepository.findById(employee.getMemberId());
        if (opt.isPresent()) {
            //this save method perform 2 operation 1. insert 2 merge
            Employee updatedEmployee=employeeRepository.save(employee);
            return updatedEmployee;
        } else
            throw new EmployeeException("Invalid Member details..");
    }


    public  Employee getEmployeeByName(String name) throws EmployeeException {
        if (name != null) {
            List<Employee> e1 = (List<Employee>) employeeRepository.getbyName(name);
            System.out.println(e1);
            return e1.get(0);
        }
        throw  new EmployeeException("name not found");
    }
    public Employee getEmployeeByNameAndCity(String name, String city) {
        return employeeRepository.findByNameAndCity(name, city);
    }
}
