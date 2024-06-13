package com.tka.OrganizationSystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tka.OrganizationSystem.dao.MainDao;
import com.tka.OrganizationSystem.entity.Country1;
import com.tka.OrganizationSystem.entity.Employee;


@Service
public class MainService {

	@Autowired
	MainDao dao;
	
public String addcountry(com.tka.OrganizationSystem.entity.Country1 c) {
		String msg=dao.addcountry(c);
		if(Objects.isNull(msg)) {
			msg="Country is not added....";
		}
		return msg;
		
	}



public String updateCountry(Country1 c) {
	// TODO Auto-generated method stub
	String msg=dao.updateCountry(c);
	if(Objects.isNull(msg)) {
		msg="country is not updated";
	}
	return msg;
}






public String deleteCountry(int id) {
	// TODO Auto-generated method stub
	String msg=dao.deleteCountry(id);
	if(Objects.isNull(msg)) {
		msg="country is not deleted";
	}
	return msg;
}





public List<Country1> getallCountry() {
	// TODO Auto-generated method stub
	List<Country1> list=dao.getallCountry();
	if(Objects.isNull(list)) {
		list=null;
	}
	return list;
}







public Country1 getcountryById(int id) {
	// TODO Auto-generated method stub
	Country1 c=dao.getcountryById(id);
	if(Objects.isNull(c)) {
		c=null;
	}
	return c;
}



public String addEmployee(Employee emp) {
	// TODO Auto-generated method stub
	
	
	String msg=dao.addEmployee(emp);
	if(Objects.isNull(msg)) {
		msg="Employee is not added";
	}
	return msg;
}



public List<Employee> getAllEmplyoee() {
	// TODO Auto-generated method stub
	List<Employee> list=dao.getAllEmplyoee();
	if(Objects.isNull(list)) {
	return null;
}
 return list;
	
}



public Employee getempployeeById(int id) {
	// TODO Auto-generated method stub
	Employee emp=dao.getparticularById(id);
	if(Objects.isNull(emp)) {
		emp= null;
		
	}
	return emp;
}






public String updateEmployee(Employee emp) {
	// TODO Auto-generated method stub
	String msg=dao.updateEmployee(emp);
	if(Objects.isNull(msg)) {
		msg="employee is not updated";
	}
	return msg;


}



public String deleteEmployee(int id) {
	// TODO Auto-generated method stub
	String msg=dao.deleteEmployee(id);
	if(Objects.isNull(msg)) {
		msg="employee is not deleted";
	}
	return msg;
}


public List<Employee> getListByStatus(String status) {
	// TODO Auto-generated method stub
	
	List<Employee> list= dao.getListByStatus(status);
	
	
	
	return list;
}





public HashMap<String, Object> loginUser(Employee e) {
	// TODO Auto-generated method stub
	
	Employee emp= dao.loginUser(e);
	
	HashMap<String, Object> map=new HashMap<String, Object>();
	
	
	if(Objects.isNull(emp)) {
			// invalid user
		
		map.put("msg", "Invalid User");
		map.put("name", emp);
		
	}else {
		//valid user 
		
		map.put("msg", "valid User");
		map.put("name", emp);
		map.put("password", emp);
		
	}
	return map;
	
}



public List<Employee> getListByDepartment(String department) {
	// TODO Auto-generated method stub
List<Employee> list= dao.getListByDepartment(department);
	
	
	
	return list;
}



public Country1 getcogetAllcountyuntryById(int id) {
	// TODO Auto-generated method stub
	return null;
}

}




