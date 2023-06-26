package com.onesoft.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class EmployeeController {
	@Autowired
	EmployeeService empserv;
	RestTemplate rest=new RestTemplate();
	@GetMapping(value="/getCarviaEmployee")
	public List<Car> getCarviaEmployee(){
		String url="http://localhost:8080/findAll";
		ResponseEntity<List<Car>> response =rest.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Car>>(){});
	List<Car> cars=response.getBody();
		return cars;
	}
	
	@GetMapping(value="/getCarId/{id}")
	public Car findbyid(@PathVariable int id) {
		String url="http://localhost:8080/findCar/";
		ResponseEntity <Car> resp =rest.exchange(url+id, HttpMethod.GET, null, new ParameterizedTypeReference <Car>() {});
		Car carId=resp.getBody();
		return carId;
	}
	
	@PostMapping(value = "/PostEmployee")
	public String addEmployee(@RequestBody Employee e) throws AgeException{
		return empserv.addEmployee(e);
	}

	@PostMapping(value = "/addEmpList")
	public String addAllEmployee(@RequestBody List<Employee> emps) {
		return empserv.addAllEmployee(emps);
	}

	@GetMapping(value = "/getId/{id}")
	public Employee findById(@PathVariable int id) throws EmployeeNotFoundException {
		return empserv.findById(id);
	}

	@GetMapping(value = "/allEmp")
	public List<Employee> findAll() {
		return empserv.findAll();
	}

	@DeleteMapping(value = "/deleteEmp/{id}")
	public String deleteById(@PathVariable int id) {
		return empserv.deleteById(id);
	}

	@PutMapping(value = "/updateEmp/{id}")
	public String updateEmp(@RequestBody Employee e) {
		return empserv.updateEmp(e);
	}
	

	@GetMapping(value = "/getByGender/{gender}")
	public List<Employee> getByGender(@PathVariable String gender) {
		return empserv.getByGender(gender);
	}

	@GetMapping(value = "/getName/{name}")
	public List<Employee> getName(@PathVariable String name) throws EmployeeMissingException{
		return empserv.getName(name);
	}

	@GetMapping(value = "/empAge/{age}")
	public List<Employee> ageEmp(@PathVariable int age)throws EmployeeMissingException {
		return empserv.ageEmp(age);
	}

	@GetMapping(value = "/salEmp/{salary}")
	public List<Employee> empSal(@PathVariable int salary) {
		return empserv.empSal(salary);
	}

	@GetMapping(value = "/maxSal")
	public Optional<Employee> maxsal() {
		return empserv.maxsal();
	}

	@GetMapping(value = "/minSal")
	public Optional<Employee> minsal() {
		return empserv.minsal();
	}
	@GetMapping(value="/getbySal/{sal1}/{sal2}")
	public List<Employee> getbySal(@PathVariable int sal1,@PathVariable int sal2){
		return empserv.getbySal(sal1,sal2);
	}
	@GetMapping(value="/getbyage/{age}")
	public List<Employee> getbyage(@PathVariable int age){
		return empserv.getbyage(age);
	}
	@GetMapping(value="/getbyName/{name}")
	public List<Employee> getbyName(@PathVariable String name){
		return empserv.getbyName(name);
	}
	@GetMapping(value="/getFeIncSal/{empl}")
	public List<Employee> getFeIncSal(@PathVariable String empl){
		return empserv.getFeIncSal(empl);
	}
	
}
