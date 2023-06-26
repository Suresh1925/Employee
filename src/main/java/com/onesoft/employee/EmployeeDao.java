package com.onesoft.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public class EmployeeDao {
@Autowired
EmployeeRepository empRepo;

public String addEmployee(Employee e) {
	empRepo.save(e);
	return "Successfully Saved";
}
public String addAllEmployee(List<Employee> emps) {
	empRepo.saveAll(emps);
	return "Successfully Saved";
}
public Employee findById(int id) throws EmployeeNotFoundException {
	
	return empRepo.findById(id).orElseThrow(()->new EmployeeNotFoundException());
}
public List<Employee> findAll(){
	empRepo.findAll();
	return empRepo.findAll();
}
public String deleteById(@PathVariable int id) {
	empRepo.deleteById(id);
	return "Deleted Successfully";
}
public String updateEmp(Employee e) {
	empRepo.save(e);
	return "Updated Successfully";
}
public List<Employee> getbySal(int sal1, int sal2) {
	// TODO Auto-generated method stub
	return empRepo.getbySal(sal1, sal2);
}
public List<Employee> getbyage(int age) {
	// TODO Auto-generated method stub
	return empRepo.getbyage(age);
}
public List<Employee> getbyName(String name) {
	// TODO Auto-generated method stub
	return empRepo.getbyName(name);
}

		

	
	
}


