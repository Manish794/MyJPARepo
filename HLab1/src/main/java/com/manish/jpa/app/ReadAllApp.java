package com.manish.jpa.app;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.manish.jpa.app.entity.Employee;
import com.manish.jpa.app.util.HibernateUtil;

public class ReadAllApp {
	public static void main(String[] args) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Query query = session.createQuery("from Employee em", Employee.class);
			List<Employee> list = query.getResultList();
			if (null != list && list.size() != 0) {
				for (Employee emp : list) {
					System.out.println(emp.getId() + "\t" + emp.getName() + "\t" + emp.getEmail() + "\t"
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
			if (null != session)
				session.close();
			HibernateUtil.shutdown();
		}

	}
}
