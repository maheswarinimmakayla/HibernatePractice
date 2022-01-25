package com.mouritech.hibernate.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Course")
public class Course {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "cid")
private int courseId;
@Column(name="cname", nullable = false)
private String courseName;
@Column(name="cfees", nullable = false)
private int courseFees;
@Column(name="cduration", nullable = false)
private String courseDuration;

public Course() {
	
}

public Course(String courseName, int courseFees, String courseDuration) {
	super();
	this.courseName = courseName;
	this.courseFees = courseFees;
	this.courseDuration = courseDuration;
}

public Course(int courseId, String courseName, int courseFees, String courseDuration) {
	super();
	this.courseId = courseId;
	this.courseName = courseName;
	this.courseFees = courseFees;
	this.courseDuration = courseDuration;
}

public int getCourseId() {
	return courseId;
}

public void setCourseId(int courseId) {
	this.courseId = courseId;
}

public String getCourseName() {
	return courseName;
}

public void setCourseName(String courseName) {
	this.courseName = courseName;
}

public int getCourseFees() {
	return courseFees;
}

public void setCourseFees(int courseFees) {
	this.courseFees = courseFees;
}

public String getCourseDuration() {
	return courseDuration;
}

public void setCourseDuration(String courseDuration) {
	this.courseDuration = courseDuration;
}

@Override
public String toString() {
	return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseFees=" + courseFees
			+ ", courseDuration=" + courseDuration + "]";
}

}

	
