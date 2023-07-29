package com.brickred.employeeapp.dto;

import com.brickred.employeeapp.model.Address;
import com.brickred.employeeapp.model.Department;
import com.brickred.employeeapp.model.Designation;
import com.brickred.employeeapp.model.ProjectAssign;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.validation.annotation.Validated;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class EmployeeDto {

//    @DateTimeFormat(fallbackPatterns = "yyyy/MM/dd")
//    private Date joiningDate;

    private String name;

    @NotEmpty
    @Pattern(regexp="^\\d{10}$", message="Invalid mobile number")
    private String mobile;


    @NotNull(message = "Email is mandatory")
    @Email(message = "Please pass a valid email")
    private String email;

    /*@NotNull
    @Digits(integer  = 6, message = "Required  6 digits ", fraction = 0)
    private Integer pinCode;*/

    @Enumerated(EnumType.STRING)
    private Designation designation;

    @Enumerated(EnumType.STRING)
    private Department department;



    @Valid
    private Address address;




}
