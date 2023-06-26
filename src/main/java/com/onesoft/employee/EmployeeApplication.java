package com.onesoft.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="Employee Details",version="2.0",description="Details of our Employees"))
public class EmployeeApplication {

	public static void main(String[] args){
		SpringApplication.run(EmployeeApplication.class, args);
	}

}
