package com.onesoft.employee;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Service
public class EmployeeService {
@Autowired
EmployeeDao empDao;


public String addEmployee(Employee e) throws AgeException{
	try{
		if(e.getAge()<18) {
	
		throw new AgeException("You are not eligible to apply");
	}
	else {
	return empDao.addEmployee(e);
	}}
catch(AgeException ae) {
	return "Your age is under our eligibility";
}
}
@PostMapping(value="addEmpList")
public String addAllEmployee(@RequestBody List<Employee> emps) {
	return empDao.addAllEmployee(emps);
}
@GetMapping(value="/getId/{id}")
public Employee findById(@PathVariable int id) throws EmployeeNotFoundException {
	return empDao.findById(id);
}
@GetMapping(value="/allEmp")
public List<Employee> findAll(){
	return empDao.findAll();
}
@DeleteMapping(value="/deleteEmp/{id}")
public String deleteById(@PathVariable int id) {
	return empDao.deleteById(id);
}
@PutMapping(value="/updateEmp/{id}")
public String updateEmp(@RequestBody Employee e) {
	return empDao.updateEmp(e);
}
@GetMapping(value="/getByGender/{gender}")
public List<Employee> getByGender(String gender){
	List<Employee> genEmp=empDao.findAll();
	List<Employee> li=genEmp.stream().filter(x->x.getGender().equalsIgnoreCase(gender)).toList();
	return li;
}
@GetMapping(value="/getName/{name}")
public List<Employee> getName(String name) throws EmployeeMissingException{
	List<Employee> namEmp=empDao.findAll();
	List<Employee> empLi=namEmp.stream().filter(x->x.getName().equalsIgnoreCase(name)).toList();
	
	if(empLi.isEmpty()) {
		throw new EmployeeMissingException();
	}
		return empLi;
	}
@GetMapping(value="/EmpAge/{age}")
public List<Employee> ageEmp(int age)throws EmployeeMissingException{
	List<Employee> agEmp=empDao.findAll();
	List<Employee> agLi=agEmp.stream().filter(x->x.getAge()>age).toList();
	if(agLi.isEmpty()) {
		throw new EmployeeMissingException();
	}
	
	return agLi;
}
public List<Employee> empSal(int salary){
	List<Employee> sal1=empDao.findAll();
	List<Employee> salry=sal1.stream().filter(x->x.getSalary()>salary).toList();
	return salry;
}
public Optional<Employee> maxsal(){
	List<Employee> max=empDao.findAll();
	Optional<Employee> maxi=max.stream().max(Comparator.comparing(Employee::getSalary));
	return maxi;
}
public Optional<Employee> minsal(){
	List<Employee> min=empDao.findAll();
	Optional<Employee> mini=min.stream().min(Comparator.comparing(Employee::getSalary));
	return mini;
}
public List<Employee> getbySal(int sal1, int sal2) {
	// TODO Auto-generated method stub
	return empDao.getbySal(sal1,sal2);
}
public List<Employee> getbyage(int age) {
	// TODO Auto-generated method stub
	return empDao.getbyage(age);
}
public List<Employee> getbyName(String name) {
	// TODO Auto-generated method stub
	return empDao.getbyName(name);
}
public List<Employee> getFeIncSal(String empl) {
	List<Employee> empl1=empDao.findAll();
	List<Employee> lie=empl1.stream().filter(x->x.getGender().equalsIgnoreCase(empl)).map(y->
	{if(y.getSalary()>2) {
		y.setSalary((y.getSalary()*5/100)+y.getSalary());
	}return y;
	
	}).toList();
	return lie;
	}


}







