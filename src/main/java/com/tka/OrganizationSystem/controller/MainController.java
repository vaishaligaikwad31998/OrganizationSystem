package com.tka.OrganizationSystem.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.tka.OrganizationSystem.entity.Country1;
import com.tka.OrganizationSystem.entity.Employee;
import com.tka.OrganizationSystem.service.MainService;

@RestController
@RequestMapping("/api")
public class MainController {

	@Autowired
	MainService service;
	
	
	@PostMapping("/addcountry")
	public String addacountry(@RequestBody Country1 c) {
		
	String msg=	service.addcountry(c);
	return msg;
		
	}
	
	//2nd api
	
	@PutMapping("/updatecounty")
	public String updateCountry(@RequestBody Country1 c) {
		String msg=service.updateCountry(c);
		return msg;
		
	}

	@DeleteMapping("/deletecounty/{id}")
	public String deleteCountry(@PathVariable int id  ) {
		String msg=service.deleteCountry(id);
		return msg;
		
	}
	@GetMapping("/")
	public List<Country1> getallCountry(){
		List<Country1> list=service.getallCountry();
		return list;
		
	}
	
	@GetMapping("/getCountryById/{id}")
	public Country1 getcountryById(@PathVariable int id) {
		Country1 c=service.getcogetAllcountyuntryById(id);
		return c;
	}
	
	//api6
	@PostMapping("/addEmp")
	public String addEmployee(@RequestBody Employee emp) {
	String msg=	service.addEmployee(emp);
	return msg;
	}
	
	@GetMapping("/getAllEmp")
	public List<Employee> getAllEmplyoee(){
		List<Employee> list=service.getAllEmplyoee();
		return list;
	}
	@GetMapping("/getById/{id}")
	public Employee getempployeeById(@PathVariable int id) {
		Employee emp=service.getempployeeById(id);
		return emp;
	
	}
	
	@PutMapping("/updateemployee")
	public String updateEmployee(@RequestBody Employee emp) {
		String msg=service.updateEmployee(emp);
		return msg;
		
	}
	@DeleteMapping("/deleteemployee/{id}")
	public String deleteEmployee(@PathVariable int id  ) {
		String msg=service.deleteEmployee(id);
		return msg;
		
	}
	
	//get record by status
	@GetMapping("/getbyStatus/{status}")
	public List<Employee> getListByStatus(@PathVariable String status){
//		System.out.println(status);
		
		List<Employee> list=service.getListByStatus(status);
		return list;
		
	}
	
	//get record by department
	@GetMapping("/getbyDepartment/{department}")
	public List<Employee> getListByDepartment(@PathVariable String department){
		List<Employee> list=service.getListByDepartment(department);
		return list;
	}
	
	
	@PostMapping("/login")
	public HashMap<?, ?> loginName(@RequestBody Employee emp) {
		
		HashMap<?, ?> map= service.loginUser(emp);
		return map;
		
	}
	
	
	
	
	
	
	
}
	


