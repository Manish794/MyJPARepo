package com.manish.jpa.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.manish.jpa.app.entity.CurrentStudent;
import com.manish.jpa.app.util.JPAUtil;

public class InsertCStudentApp {
	public static void main(String[] args) {
		EntityManager entityManager = null;
		EntityTransaction tx = null;
		try {
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			tx = entityManager.getTransaction();
			tx.begin();

			CurrentStudent cstud = new CurrentStudent();
			cstud.setName("Aadi");
			cstud.setEmail("aadi@oits.com");
			cstud.setTimings("7.30 AM to 9.30 AM");
			cstud.setBatch("B1");
			entityManager.persist(cstud);

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
