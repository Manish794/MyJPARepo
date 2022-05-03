package com.manish.jpa.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.manish.jpa.app.entity.Course;
import com.manish.jpa.app.entity.Student;
import com.manish.jpa.app.util.JPAUtil;


public class InsertApp {
	public static void main(String[] args) {
		EntityManager entityManager = null;
		EntityTransaction tx = null;
		try {
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			tx = entityManager.getTransaction();
			tx.begin();

			Course c1 = new Course();
			c1.setName("Java");
			c1.setFee(5000);
			c1.setDuration("2 Month");
			entityManager.persist(c1);
			
			Course c2 = new Course();
			c2.setName("HTML");
			c2.setFee(1000);
			c2.setDuration("15 Days");
			entityManager.persist(c2);

			Course c3 = new Course();
			c3.setName("Spring");
			c3.setFee(10000);
			c3.setDuration("1 Month");
			entityManager.persist(c3);

			Student stud = new Student();
			stud.setName("Manish");
			stud.setEmail("Manish@oits.com");
			stud.setPhone(9696969696L);
			stud.setCourses(List.of(c1, c2));
			entityManager.persist(stud);
				
			Student stud2 = new Student();
			stud2.setName("Rahul");
			stud2.setEmail("rahul@oits.com");
			stud2.setPhone(9292929292L);
			stud2.setCourses(List.of(c1, c3));
			entityManager.persist(stud2);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (null != tx)
				tx.rollback();
		} finally {
			if (null != entityManager)
				entityManager.close();
		}
	}
}
