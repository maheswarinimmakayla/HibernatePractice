package com.mouritech.emswithrestandhibernate.repository;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.mouritech.emswithrestandhibernate.entity.Employee;
import com.mouritech.emswithrestandhibernate.util.HibernateUtil;

public class EmployeeRepository {
	public List<Employee> getAllEmployees() {
		
		Transaction transaction = null;
		List<Employee> empList = null;
		try {
		Session session = HibernateUtil.getSessionFactory().openSession();
			
			// start the transaction
			transaction = session.beginTransaction();
			
			
			//get entity from database
			empList = session.createQuery("from Employee").getResultList();
	
			//commit transaction
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		return empList;
	}



public Employee addEmployee(Employee emp) {
	Transaction transaction = null;
	try {
		Session session = HibernateUtil.getSessionFactory().openSession();
	
		
		// start the transaction
		transaction = session.beginTransaction();
		// save the employee object in to database
		session.save(emp);
		// commit transaction
		transaction.commit();
	}catch (Exception e) {
		if (transaction != null) {
			transaction.rollback();
		}

		e.printStackTrace();
	}
	return emp;
}

public String deleteEmployee(int empid) {
	// TODO Auto-generated method stub
	return null;
}

public Employee updateEmployee(int empid, Employee emp) {
	// TODO Auto-generated method stub
	return null;
}

public Employee getEmployeeById(int empid) {
	// TODO Auto-generated method stub
	return null;
}
}
