package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import com.hibernate.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		
		// create session factory
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//create the objects
			/*Instructor tempInstructor = 
					new Instructor("Chad","Darby","darby@gmail.com");
			
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail("https://youtube1.com","coding ");
			*/
			
			Instructor tempInstructor = 
					new Instructor("Madhu","Patel","madhu@gmail.com");
			
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail("https://youtube2.com","guitar");
			
			//associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//begin the transaction
			session.beginTransaction();
			
			//save the instructor
			System.out.println("saving instructor" + tempInstructor);
			session.save(tempInstructor);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		
		finally {
			factory.close();
		}
	}

}
