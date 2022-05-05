package com.manish.jpa.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.manish.jpa.app.entity.Student;
import com.manish.jpa.app.util.JPAUtil;

public class ReadAllWithFilteredColumnWithJPQLApp {
	public static void main(String[] args) {
		EntityManager entityManager = null;
		EntityTransaction tx = null;
		try {
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			tx = entityManager.getTransaction();
			tx.begin();
			
			
			Query qry = entityManager.createQuery("SELECT st.sid, st.email from Student st");
			List list = qry.getResultList();
			
			if (list == null || list.size() == 0) {
				System.out.println("Not Found");
			} else {
				List<Object[]> studList = (List<Object[]>) list;
				for (Object[] values : studList) {
					Integer id = (Integer) values[0];
					String email = (String) values[1];

					System.out.println(id + "\t" + email);
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
