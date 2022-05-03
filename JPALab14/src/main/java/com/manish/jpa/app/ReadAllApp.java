package com.manish.jpa.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.manish.jpa.app.entity.Employee;
import com.manish.jpa.app.util.JPAUtil;

public class ReadAllApp {
	public static void main(String[] args) {
		EntityManager entityManager = null;
		EntityTransaction tx = null;
		try {
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			tx = entityManager.getTransaction();
			tx.begin();
			Query query = entityManager.createQuery("SELECT em from Employee em", Employee.class);
			List<Employee> list = query.getResultList();
			if (null != list && list.size() != 0) {
				for (Employee emp : list) {
					System.out.println(emp.getEmployeeId() + "\t" + emp.getName() + "\t" + emp.getEmail() + "\t"
							+ emp.getPhone() + "\t" + emp.getDoj());
				}
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
