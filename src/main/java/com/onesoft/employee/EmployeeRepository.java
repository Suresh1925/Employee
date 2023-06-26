package com.onesoft.employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	
@Query(value="select * from employee where salary >=? AND salary<=?",nativeQuery = true)
public List<Employee> getbySal(int sal1,int sal2);

@Query(value="select * from employee where age >=?",nativeQuery = true)
public List<Employee> getbyage(int age1);
@Query(value="SELECT * from employee where name like %?%",nativeQuery = true)
public List<Employee> getbyName(String name);
}