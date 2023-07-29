package com.brickred.employeeapp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.validation.annotation.Validated;

@SpringBootApplication
@EnableJpaRepositories
@Validated
@OpenAPIDefinition(info = @Info(title = "EMPLOYEE API", version = "V 0.1.0", description = "A application for an Employee App ."))
public class EmployeeappApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeappApplication.class, args);
	}

}
