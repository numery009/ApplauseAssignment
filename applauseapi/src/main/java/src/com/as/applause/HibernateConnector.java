/*
 * Author : Numery Zaber
 * Position: Software Engineer
 * Compnay : Omninitivity Inc.
 * Module : Hibernate Connector with Database for all Module
 * Layer : Common
 * Date: Oct-05-2015
 */

package src.com.as.applause;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateConnector {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {

		Configuration configuration = new Configuration();

		configuration.configure();

		@SuppressWarnings("deprecation")
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();	
		
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(serviceRegistry);

		return sessionFactory;

	}

	public static SessionFactory getSessionFactory() {

		return sessionFactory;

	}

}