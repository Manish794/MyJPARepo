package com.manish.jpa.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.manish.jpa.app.entity.Course;
import com.manish.jpa.app.util.JPAUtil;

public class InsertCourseApp {
	public static void main(String[] args) {
		EntityManager entityManager = null;
		EntityTransaction tx = null;
		try {
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			tx = entityManager.getTransaction();
			tx.begin();

			Course c1 = new Course();
			c1.setName("JPA");
			c1.setFee(2000);
			c1.setDuration("15 Days");
			entityManager.persist(c1);
			
			Course c2 = new Course();
			c2.setName("CSS");
			c2.setFee(1000);
			c2.setDuration("7 Days");
			entityManager.persist(c2);

			Course c3 = new Course();
			c3.setName("ReactJS");
			c3.setFee(10000);
			c3.setDuration("15 Days");
			entityManager.persist(c3);
		
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
