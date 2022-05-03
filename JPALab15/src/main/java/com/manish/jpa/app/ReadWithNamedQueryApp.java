package com.manish.jpa.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.manish.jpa.app.entity.Student;
import com.manish.jpa.app.util.JPAUtil;

public class ReadWithNamedQueryApp {
	public static void main(String[] args) {
		EntityManager entityManager = null;
		EntityTransaction tx = null;
		try {
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			tx = entityManager.getTransaction();
			tx.begin();

			Query qry = entityManager.createNamedQuery("CityWiseStudent");
			qry.setParameter(1, "Blore");
			List list = qry.getResultList();

			if (list == null || list.size() == 0) {
				System.out.println("Not Found");
			} else {
				List<Student> studList = (List<Student>) list;
				for (Student st : studList) {
					System.out.println(st.getSid() + "\t" + st.getSname() + "\t" + st.getEmail() + "\t" + st.getCty());
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
