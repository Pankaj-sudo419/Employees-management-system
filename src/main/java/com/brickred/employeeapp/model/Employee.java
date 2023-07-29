package com.brickred.employeeapp.model;

import jakarta.persistence.Entity;
import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;



@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer memberId;

//    @DateTimeFormat(fallbackPatterns = "yyyy/MM/dd")
//    private Date joiningDate;


     @NotEmpty
    private String name;



    @NotEmpty

    private String mobile;

    @NotEmpty

    private String email;

    private  Designation designation;
    private Department department;
    @Embedded
    private Address address;

    @OneToOne(mappedBy = "employee")
    private ProjectAssign projectAssign;


}
