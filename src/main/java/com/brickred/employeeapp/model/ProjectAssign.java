package com.brickred.employeeapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjectAssign {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;


    private  int id;
    private String Dev;
    private  String testing;
    private  String Devops;
    private String saleforce;

}
