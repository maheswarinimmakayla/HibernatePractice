package com.mouritech.hibernateexamples;
import org.hibernate.Session;
import java.util.List;
import org.hibernate.Transaction;
import com.mouritech.hibernate.entity.Course;
import com.mouritech.hibernate.entity.Student;
import com.mouritech.hibernate.util.HibernateUtil;

public class HibernateExMain {
public static void main(String[] args) {
	Student std = new Student(124L, "rama", "ramareddy", "ramass");
	Student std1 = new Student(125L, "sitha", "sithadev", "ddds");
	
	Course course = new Course(123,"java",4500,"threemonths");
	Course course1 = new Course(124,"python",3500,"threemonths");
	Course course2 = new Course(125,"angular",2500,"threemonths");
	Course course3 = new Course(126,"DBMS",1500,"threemonths");
	
        Transaction transaction = null;
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {

		// start the transaction
		transaction = session.beginTransaction();
		// save the student objects in to database
		session.save(std);
		session.save(std1);
		// commit transaction
		transaction.commit();

	} catch (Exception e) {

		if (transaction != null) {
			transaction.rollback();
		}

		e.printStackTrace();
	}

	// retrieve the data from database to java program using hibernate

	try (Session session = HibernateUtil.getSessionFactory().openSession()) {

		List<Student> studentList = session.createQuery("from Student", Student.class).list();
		studentList.forEach(stud -> System.out.println(stud));

	} catch (Exception e) {
		if (transaction != null) {
			transaction.rollback();
		}
		e.printStackTrace();
	}
	// add course details
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {

		List<Course> courseList = session.createQuery("from Course", Course.class).list();
		courseList.forEach(cr -> System.out.println(cr));

	} catch (Exception e) {
		if (transaction != null) {
			transaction.rollback();
		}
		e.printStackTrace();
	}
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {

		// start the transaction
		transaction = session.beginTransaction();
		// save the student objects in to database
		session.save(course);
		session.save(course1);
		session.save(course2);
		session.save(course3);
		
		// commit transaction
		transaction.commit();

	} catch (Exception e) {

		if (transaction != null) {
			transaction.rollback();
		}

		e.printStackTrace();
	}
	

}
}
