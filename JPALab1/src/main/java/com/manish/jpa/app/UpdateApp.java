package com.manish.jpa.app;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.manish.jpa.app.entity.Employee;
import com.manish.jpa.app.util.JPAUtil;

public class UpdateApp {
	public static void main(String[] args) {
		EntityManager entityManager = null;
		EntityTransaction tx = null;
		try {
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			tx = entityManager.getTransaction();
			tx.begin();

			Employee emp = entityManager.find(Employee.class, 1);
			if (null != emp) {
				emp.setName("Aadi");
				emp.setEmail("aadi@gmail.com");
				emp.setPhone(989898989);
				emp.setDoj(new Date());
				entityManager.merge(emp);
			} else {
				System.out.println("Data not found to update");
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
