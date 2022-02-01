package com.mouritech.employeemanagement.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mouritech.employeemanagement.entity.Employee;
import com.mouritech.employeemanagement.util.HibernateUtil;

public class EmployeeDao {
	public List<Employee> getAllEmployees() {
		Transaction transaction = null;
		List<Employee> empList = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
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

	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return null;
	}
}
