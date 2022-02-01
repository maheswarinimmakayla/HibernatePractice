package com.mouritech.departmentmanagement.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mouritech.departmentmanagement.entity.Department;
import com.mouritech.departmentmanagement.util.HibernateUtil;




public class DepartmentDao {
	public List<Department> getAllDepartments() {
		Transaction transaction = null;
		List<Department> deptList = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			
			
			//get entity from database
			deptList = session.createQuery("from Department").getResultList();
	
			//commit transaction
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		return deptList;
	}

	public void saveDepartment(Department dept) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the department object in to database
			session.save(dept);
			// commit transaction
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
	}

	public void deleteEmployee(Integer deptid) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		
		{
			
			// start the transaction
			transaction = session.beginTransaction();
			
			//find the department object from the database
			Department dept = session.get(Department.class, deptid);
			if(dept != null)
				
			{
				
			// delete the department object in to database
				
			session.delete(dept);
			System.out.println("Department deleted");
			}
				
			// commit transaction
			transaction.commit();
		}catch (Exception e)
		{
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		
	}

	public void updateDeartment(Department dept) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();

			session.saveOrUpdate(dept);
	
			// commit transaction
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		
	}

	public Department getDepartment(Integer deptid) {
		Transaction transaction = null;
		Department deptById = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
		
			
			//get entity from database using employee id
			deptById = session.get(Department.class, deptid);
			if(deptById!=null) {
				
				System.out.println("Department details are = " + deptById);
			}
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		return deptById;
	}

	public void updateDepartment(Department dept) {
		// TODO Auto-generated method stub
		
	}
	
}
