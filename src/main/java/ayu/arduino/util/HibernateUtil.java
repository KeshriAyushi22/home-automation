package ayu.arduino.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	private static SessionFactory buildSessionFactory() {
		try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
					.buildServiceRegistry();
			SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
			return factory;
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {

		return (sessionFactory!=null)?sessionFactory:buildSessionFactory();
		
	}

	public static void shutdown() {
		getSessionFactory().close();
	}





}
