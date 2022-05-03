package com.manish.jpa.app.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static final String PERSISTENCE_UNIT_NAME = "JPALabPersistence";
	private static EntityManagerFactory factory = buildEntityManagerFactory();

	private static final EntityManagerFactory buildEntityManagerFactory() {
		try {
			return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return factory;
	}
}
