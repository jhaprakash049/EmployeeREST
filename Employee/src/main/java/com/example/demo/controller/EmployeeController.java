package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	private EmployeeService employeeServive;

	public EmployeeController(EmployeeService employeeServive) {
		super();
		this.employeeServive = employeeServive;
	}

	@PostMapping("/employees")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
	{
		System.out.println("prakash");
		System.out.println(employee.getFirstName());
		return new ResponseEntity<Employee>(employeeServive.saveEmployee(employee),HttpStatus.CREATED);
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees()
	{
		return employeeServive.getAllEmployees();
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId)
	{
		return new ResponseEntity<Employee>(employeeServive.getEmployeeById(employeeId), HttpStatus.OK);
	}
	
	@PostMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee)
	{
		return new ResponseEntity<Employee>(employeeServive.updateEmployee(employee, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id)
	{
		employeeServive.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted successfully", HttpStatus.OK);
	}
}
