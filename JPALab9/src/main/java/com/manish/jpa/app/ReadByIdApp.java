package com.manish.jpa.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.manish.jpa.app.entity.Course;
import com.manish.jpa.app.entity.Student;
import com.manish.jpa.app.util.JPAUtil;

public class ReadByIdApp {
	public static void main(String[] args) {
		EntityManager entityManager = null;
		EntityTransaction tx = null;
		try {
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			tx = entityManager.getTransaction();
			tx.begin();

			Student stu = entityManager.find(Student.class, 2);
			if (null != stu) {
				System.out.println(stu.getSid() + "\t" + stu.getName());
				List<Course> courses = stu.getCourses();
				if (null != courses) {
					for (Course c : courses) {
						System.out.println(c.getName()+"\t"+c.getDuration()+"\t"+c.getFee());
					}
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
