package com.mouritech.departmentmanagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mouritech.departmentmanagement.dao.DepartmentDao;
import com.mouritech.departmentmanagement.entity.Department;



/**
 * Servlet implementation class DepartmentServlet
 */
public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DepartmentDao deptDao;

	public void init() {
		deptDao = new DepartmentDao();
	}
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(req, resp);
		}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();

		try {

			switch (action) {
			case "/new":
				showNewDepartmentForm(req,resp);
				break;
			case "/insert":
				insertDepartment(req,resp);
				break;
			case "/list":
				listDepartment(req,resp);
				break;
			case "/update":
				updateDepartment(req,resp);
				break;
			case "/edit":	
				showEditDepartmentForm(req,resp);
				break;
			/*case "/delete":
				deleteDepartment(req,resp);
				break;*/
			default:
				break;
			}//close of switch

		} catch (Exception e) {
			e.printStackTrace();
		}//close catch
		
	}//close of doPost
	
	private void showEditDepartmentForm(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException,ServletException,SQLException {
		Integer deptid = Integer.parseInt(req.getParameter("id"));
		
		Department existingDepartment = deptDao.getDepartment(deptid);
		RequestDispatcher rd = req.getRequestDispatcher("department-form.jsp");
		req.setAttribute("existingDepartment", existingDepartment);
		rd.forward(req, resp);
	}

	private void updateDepartment(HttpServletRequest req, HttpServletResponse resp) 	
			throws IOException,ServletException,SQLException {
		Integer deptid = Integer.parseInt(req.getParameter("deptid"));
		String deptname = req.getParameter("deptname");
		String deptemail = req.getParameter("deptemail");
		String deptmobno = req.getParameter("deptmobno");
		
		Department dept = new Department(deptid,deptname,deptemail,deptmobno);
		deptDao.updateDepartment(dept);
		resp.sendRedirect("list");
		
	}

	/*private void deleteDepartment(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException,ServletException,SQLException {
		Integer empid = Integer.parseInt(req.getParameter("id"));
		deptDao.deleteDepartment(deptid);
		resp.sendRedirect("list");
		
	}*/

	private void insertDepartment(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		Integer deptid = Integer.parseInt(req.getParameter("deptid"));
		String deptname = req.getParameter("deptname");
		String deptemail = req.getParameter("deptemail");
		String deptmobno = req.getParameter("deptmobno");
		
		Department dept = new Department(deptname,deptemail,deptmobno);
		deptDao.saveDepartment(dept);
		resp.sendRedirect("list");
		
	}

	private void showNewDepartmentForm(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("department-form.jsp");
		rd.forward(req, resp);
		
	}
	private void listDepartment(HttpServletRequest req,HttpServletResponse res) 
			throws ServletException, IOException ,SQLException {
		
		List<Department> listOfDepartments  = deptDao.getAllDepartments();
		req.setAttribute("listDept",listOfDepartments );
		RequestDispatcher rd = req.getRequestDispatcher("Department-list.jsp");
		rd.forward(req, res);
	}
}
