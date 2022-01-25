package com.mouritech.hibernate.entity;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Student {
	@Id
	private Long studentId;
	private String studentName;
	private String studentFirstName;
	private String studentLastName;
	
	public Student(String studentName, String studentFirstName, String studentLastName) {
		super();
		this.studentName = studentName;
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
	}
	public Student(Long studentId, String studentName, String studentFirstName, String studentLastName) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentFirstName() {
		return studentFirstName;
	}
	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}
	public String getStudentLastName() {
		return studentLastName;
	}
	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentFirstName="
				+ studentFirstName + ", studentLastName=" + studentLastName + "]";
	}
	
}
