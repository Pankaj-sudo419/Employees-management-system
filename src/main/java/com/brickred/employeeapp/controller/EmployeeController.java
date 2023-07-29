package com.brickred.employeeapp.controller;

import com.brickred.employeeapp.dto.EmployeeDto;
import com.brickred.employeeapp.exception.EmployeeException;
import com.brickred.employeeapp.model.Employee;
import com.brickred.employeeapp.service.EmployeeServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
@CrossOrigin("*")

public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;

     @PostMapping("/add")
     @Operation(summary = "Save File to the disk", operationId = "1", description = "Save the file to the disk by passing json value")
     public ResponseEntity<String> registerEmployee(@Valid @RequestBody  EmployeeDto employeeDto) throws EmployeeException {

          employeeService.registerEmployee(employeeDto);
        return   ResponseEntity.ok("WELCOME TO BRICKRED");

     }
    @GetMapping("/byid/{id}")
    public ResponseEntity<Employee> registerEmployee(@PathVariable("id")  Integer id) throws EmployeeException {

       Employee e1= employeeService.getbyId(id);
//        HttpHeaders h1=new HttpHeaders();
//        h1.add("Access-Control-Allow-Origin", "*");
//        h1.add("connection" ,"keep-alive");
//        h1.add("content-type", "application/json" );
        return new ResponseEntity<Employee>(e1,HttpStatus.OK);

    }
    @GetMapping("/getAllEmployee")
    public ResponseEntity<List<Employee>> getAllEmployee() throws EmployeeException {

        List<Employee> e1= employeeService.getallMember();
//        HttpHeaders h1=new HttpHeaders();
//        h1.add("Access-Control-Allow-Origin", "*");
//        h1.add("connection" ,"keep-alive");
//        h1.add("content-type", "application/json" );
        return new ResponseEntity<List<Employee>>(e1,HttpStatus.OK);

   }
    @GetMapping("/{name}")
    public ResponseEntity<Employee> getEmployeeByName(@PathVariable String name) throws EmployeeException {
        Employee e1= employeeService.getEmployeeByName(name);
        if (e1 != null) {
            return new ResponseEntity<>(e1, HttpStatus.OK);
        } else {
           throw  new EmployeeException("not found");
        }
    }


    @GetMapping("/findbyCityandName")
    public ResponseEntity<Employee> getEmployeeByNameAndCity(
                                                       @RequestParam("name") String name,
                                                             @RequestParam("city") String city) {
        Employee employee = employeeService.getEmployeeByNameAndCity(name, city);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



@DeleteMapping("/deleteemployee/{id}")
public ResponseEntity<Employee> deleteMemberByIdHandler(@PathVariable("id") Integer id) throws EmployeeException {

   Employee deletedEmployee= employeeService.deleteEmployeebyID(id);

    return new ResponseEntity<Employee>(deletedEmployee,HttpStatus.OK);


}
    @PutMapping("/employee/update")
    public ResponseEntity<Employee> updateMemberHandler(@RequestBody Employee employee) throws EmployeeException {

        Employee updatedEmployee=employeeService.updateEmployeeDetails(employee);

        return new ResponseEntity<Employee>(updatedEmployee,HttpStatus.ACCEPTED);

    }


}
