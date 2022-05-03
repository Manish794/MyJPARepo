package com.manish.jpa.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.manish.jpa.app.entity.OnlineStudent;
import com.manish.jpa.app.util.JPAUtil;

public class InsertOnStudentApp {
	public static void main(String[] args) {
		EntityManager entityManager = null;
		EntityTransaction tx = null;
		try {
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			tx = entityManager.getTransaction();
			tx.begin();

			OnlineStudent onstud = new OnlineStudent();
			onstud.setName("Raj");
			onstud.setEmail("raj@oits.com");
			onstud.setTimings("7.45 AM to 9.45 AM");
			onstud.setBatch("B2");
			onstud.setLink("http://oits.com");
			onstud.setPasscode("1234abcd");
			entityManager.persist(onstud);

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
