package com.tka.OrganizationSystem.dao;

import java.util.List;



import org.hibernate.Session;




import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import com.tka.OrganizationSystem.entity.Country1;
import com.tka.OrganizationSystem.entity.Employee;



@Repository
public class MainDao {
	
	@Autowired
	SessionFactory factory;
	private String hqlQuery;

	public String addcountry(Country1 c) {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		String msg=null;
		try {
		
		session=factory.openSession();
		tx=session.beginTransaction();
		session.persist(c);
		tx.commit();
		msg="Country Added Successfully";
		
		
		}catch(Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return msg;
	}
	
	public String  updateCountry(Country1 c) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		try {
			
			session=factory.openSession();
			tx=session.beginTransaction();
			
		Country1 country=	session.get(Country1.class, c.getCid());
		country.setCname(c.getCname());
		session.merge(country);
		tx.commit();
		msg="country is updated successfully";
	}catch(Exception e) {
		if(tx!=null) {
			tx.rollback();
		}
		e.printStackTrace();
	}finally {
		if(session!=null) {
			session.close();
		}
	}
	
	return msg;
}

	public String deleteCountry(int id) {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
try {
			
			session=factory.openSession();
			tx=session.beginTransaction();
			Country1 country=session.get(Country1.class, id);
			session.remove(country);
			tx.commit();
			msg="country is deleted successfully";
		
}catch(Exception e) {
	if(tx!=null) {
		tx.rollback();
	}
	e.printStackTrace();
}finally {
	if(session!=null) {
		session.close();
	}
}

return msg;
}
      
      @GetMapping("/getAllcountry")
	public List<Country1> getallCountry() {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		List<Country1> list=null;
		hqlQuery = "from Country1";
		try {
			
			session=factory.openSession();
			tx=session.beginTransaction();
		Query<Country1> query=	session.createQuery(hqlQuery, Country1.class);
			list=query.list();
			tx.commit();
		}catch(Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}

		return list;
		
	
	}

	public Country1 getcountryById(int id) {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		Country1 c=null;
try {
			
			session=factory.openSession();
			tx=session.beginTransaction();
		c=	session.get(Country1.class, id);
		tx.commit();
}catch(Exception e) {
	if(tx!=null) {
		tx.rollback();
	}
	e.printStackTrace();
}finally {
	if(session!=null) {
		session.close();
	}
}

return c;


}

	public String addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		String msg=null;
try {
			
			session=factory.openSession();
			tx=session.beginTransaction();
			session.persist(emp);
			tx.commit();
			msg="employee added successfully";
}catch(Exception e) {
	if(tx!=null) {
		tx.rollback();
	}
	e.printStackTrace();
}finally {
	if(session!=null) {
		session.close();
	}
}
		return msg;
	}

	public List<Employee> getAllEmplyoee() {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		 List<Employee> list=null;
		String hqlQuery="from Employee";
		
try {
			
			session=factory.openSession();
			tx=session.beginTransaction();
			Query<Employee> query=session.createQuery(hqlQuery, Employee.class);
			list=query.list();
			tx.commit();
			
}catch(Exception e) {
	if(tx!=null) {
		tx.rollback();
	}
	e.printStackTrace();
}finally {
	if(session!=null) {
		session.close();
	}
}
		return list;
	}

	
	public Employee getparticularById(int id) {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		 
		Employee emp=null;
		
		
try {
	session=factory.openSession();
	tx=session.beginTransaction();
	emp=session.get(Employee.class, id);
	tx.commit();
}catch(Exception e) {
	if(tx!=null) {
		tx.rollback();
	}
	e.printStackTrace();
}finally {
	if(session!=null) {
		session.close();
	}
}
	
		return emp;
	}

	public String  updateEmployee(Employee emp) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		try {
			
			session=factory.openSession();
			tx=session.beginTransaction();
			
			Employee employee=	session.get(Employee.class, emp.getId());
			employee.setName(emp.getName());
		session.merge(employee);
		tx.commit();
		msg="employee is updated successfully";
	}catch(Exception e) {
		if(tx!=null) {
			tx.rollback();
		}
		e.printStackTrace();
	}finally {
		if(session!=null) {
			session.close();
		}
	}
	
	return msg;

	}

	public String deleteEmployee(int id) {
		// TODO Auto-generated method stubSession session=null;
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
try {
			
			session=factory.openSession();
			tx=session.beginTransaction();
			Employee employee=session.get(Employee.class, id);
			session.remove(employee);
			tx.commit();
			msg="employee is deleted successfully";
		
}catch(Exception e) {
	if(tx!=null) {
		tx.rollback();
	}
	e.printStackTrace();
}finally {
	if(session!=null) {
		session.close();
	}
}

return msg;
}
	public List<Employee> getListByStatus(String status) {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		List<Employee> list=null;
		String hqlQuery="from Employee where status=:status";
		
		try {
			
			session= factory.openSession();
			tx= session.beginTransaction();
			
			Query<Employee> query= session.createQuery(hqlQuery,Employee.class);
			query.setParameter("status", status);
				
			list= query.list();
			tx.commit();
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
			
			if(tx!=null) {
				tx.rollback();
			}	
			
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		
		return list;
	}

	public Employee loginUser(Employee emp) {
		// TODO Auto-generated method stub
		
		Session session=null;
		Transaction tx=null;
		String hqlQuery="from Employee where name=:name and password=:password";
		Employee employee=null;
		
		try {
			
			session=factory.openSession();
			tx= session.beginTransaction();
			
			Query<Employee> query= session.createQuery(hqlQuery,Employee.class);
			query.setParameter("name", emp.getName());
			query.setParameter("password", emp.getPassword());
			
			employee=query.uniqueResult();
			
			tx.commit();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return employee;
		
	}

	public List<Employee> getListByDepartment(String department) {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		List<Employee> list=null;
		String hqlQuery="from Employee where department=:department";
		
		try {
			
			session= factory.openSession();
			tx= session.beginTransaction();
			
			Query<Employee> query= session.createQuery(hqlQuery,Employee.class);
			query.setParameter("department", department);
				
			list= query.list();
			tx.commit();
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
			
			if(tx!=null) {
				tx.rollback();
			}	
			
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return list;
	}

		
	
}

		
		