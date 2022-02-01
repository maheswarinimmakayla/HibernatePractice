package com.mouritech.emswithrestandhibernate.controller;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mouritech.emswithrestandhibernate.entity.Employee;
import com.mouritech.emswithrestandhibernate.service.EmployeeService;
@Path("api/v1/employee")
public class EmployeeController {
EmployeeService empService = new EmployeeService();
	
	@Path("/getallemployees")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getAllEmployees(){
		return empService.getAllEmployees();
	}
	
	@Path("/getemployeebyid/{empid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployeeById(@PathParam("empid") int empid){
		return empService.getEmployeeById(empid);
	}
	
	@Path("/addemployee")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Employee addEmployee(Employee emp){
		return empService.addEmployee(emp);
	}
	
	@Path("/deleteemployee/{empid}")
	@DELETE
	public String deleteEmployee(@PathParam("empid") int empid){
		return empService.deleteEmployee(empid);
	}
	
	@Path("/updateemployee/{empid}")
	@PUT
	public Employee updateEmployee(@PathParam("empid") int empid,Employee emp){
		return empService.updateEmployee(empid,emp);
	}
}
