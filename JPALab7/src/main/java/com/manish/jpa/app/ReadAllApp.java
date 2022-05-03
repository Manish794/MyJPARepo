package com.manish.jpa.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.manish.jpa.app.entity.Student;
import com.manish.jpa.app.util.JPAUtil;

public class ReadAllApp {
	public static void main(String[] args) {
		EntityManager entityManager = null;
		EntityTransaction tx = null;
		try {
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			tx = entityManager.getTransaction();
			tx.begin();

			Query query = entityManager.createQuery("SELECT st from Student st", Student.class);
			List<Student> list = query.getResultList();
			if (null != list && list.size() != 0) {
				for (Student stu : list) {
					System.out.println(stu.getSid() + "\t" + stu.getName() + "\t" + stu.getEmail() + "\t"
							+ stu.getPhone() + "\t" + stu.getAddress().getAid() + "\t" + stu.getAddress().getStreet()
							+ "\t" + stu.getAddress().getCity());
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
