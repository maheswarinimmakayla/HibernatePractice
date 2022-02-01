package com.mouritech.emswithrestandhibernate.service;

import java.util.List;

import com.mouritech.emswithrestandhibernate.entity.Employee;
import com.mouritech.emswithrestandhibernate.repository.EmployeeRepository;
public class EmployeeService {
	EmployeeRepository empDao = new EmployeeRepository();

	public List<Employee> getAllEmployees() {
		
		return empDao.getAllEmployees();
	}

	public Employee addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return empDao.addEmployee(emp);
	}

	public String deleteEmployee(int empid) {
		// TODO Auto-generated method stub
		return empDao.deleteEmployee(empid);
	}

	public Employee updateEmployee(int empid,Employee emp) {
		// TODO Auto-generated method stub
		return empDao.updateEmployee(empid,emp);
	}

	public Employee getEmployeeById(int empid) {
		// TODO Auto-generated method stub
		return empDao.getEmployeeById(empid);
	}
}
