package com.manish.jpa.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.manish.jpa.app.entity.OnlineStudent;
import com.manish.jpa.app.util.JPAUtil;

public class ReadByIdApp {
	public static void main(String[] args) {
		EntityManager entityManager = null;
		EntityTransaction tx = null;
		try {
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			tx = entityManager.getTransaction();
			tx.begin();
			OnlineStudent stu = entityManager.find(OnlineStudent.class, 2);
			if (null != stu) {
				System.out.println(
						stu.getSid() + "\t" + stu.getName() + "\t" + stu.getBatch() + "\t" + stu.getPasscode());
			} else {
				System.out.println("Not Found");
			}
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
