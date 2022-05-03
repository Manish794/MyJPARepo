package com.manish.jpa.app;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.manish.jpa.app.entity.Employee;
import com.manish.jpa.app.util.HibernateUtil;

public class UpdateApp {
	public static void main(String[] args) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Employee emp = session.find(Employee.class, 1);
			if (null != emp) {
				emp.setName("Aadi");
				emp.setEmail("aadi@gmail.com");
				emp.setPhone(989898989);
				emp.setDoj(new Date());
				session.update(emp);
			} else {
				System.out.println("Data not found to update");
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (null != tx)
				tx.rollback();
		} finally {
			if (null != session)
				session.close();
			HibernateUtil.shutdown();
		}

	}
}
