package com.brickred.employeeapp.dto;

import com.brickred.employeeapp.model.ProjectAssign;
import jakarta.validation.Valid;

public class ProjectAssignDto {


    private String Dev;
    private  String testing;
    private  String Devops;
    private String saleforce;
    @Valid
    private ProjectAssign projectAssign;
}
