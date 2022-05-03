package com.manish.jpa.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.manish.jpa.app.util.JPAUtil;

public class ReadWithNativeQueryApp {
	public static void main(String[] args) {
		EntityManager entityManager = null;
		EntityTransaction tx = null;
		try {
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			tx = entityManager.getTransaction();
			tx.begin();

			List<Object[]> list = entityManager.createNativeQuery("SELECT * FROM mystudent").getResultList();
			if (list == null || list.size() == 0) {
				System.out.println("Not Found");
			} else {
				for (Object[] values : list) {
					Integer id = (Integer) values[0];
					String name = (String) values[1];
					String email = (String) values[2];
					String city = (String) values[3];
					System.out.println(id + "\t" + name + "\t" + email + "\t" + city);
				}
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
