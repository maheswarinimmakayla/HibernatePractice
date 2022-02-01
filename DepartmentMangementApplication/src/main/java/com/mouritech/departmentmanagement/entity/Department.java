package com.mouritech.departmentmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name = "department_table")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "departmentid")
	private int deptId;
	
	@Column(name = "departmentname")
	@Size(min=3)
	private String deptName;
	
	@Column(name = "departmentemail")
	@Email
	private String deptEmail;
	
	@Column(name = "departmentmobno")
	@Pattern(regexp = "[0-9]", message="mobile number contains only digits")
	private String deptMobileNo;
	
	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(String deptName, String deptEmail, String deptMobileNo) {
		super();
		this.deptName = deptName;
		this.deptEmail = deptEmail;
		this.deptMobileNo = deptMobileNo;
	}

	public Department(int deptId, String deptName, String deptEmail, String deptMobileNo) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptEmail = deptEmail;
		this.deptMobileNo = deptMobileNo;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptEmail() {
		return deptEmail;
	}

	public void setDeptEmail(String deptEmail) {
		this.deptEmail = deptEmail;
	}

	public String getDeptMobileNo() {
		return deptMobileNo;
	}

	public void setDeptMobileNo(String deptMobileNo) {
		this.deptMobileNo = deptMobileNo;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", deptEmail=" + deptEmail + ", deptMobileNo="
				+ deptMobileNo + "]";
	}
	
	
	
}
