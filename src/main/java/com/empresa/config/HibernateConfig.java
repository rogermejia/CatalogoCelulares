package com.empresa.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.empresa.entidades.Marca;
import com.empresa.entidades.MarcaPro;
import com.empresa.entidades.Producto;
import com.empresa.entidades.Proveedor;

public class HibernateConfig {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {

		if (sessionFactory == null) {

			try {

				Configuration configuration = new Configuration();

				// Hibernate settings equivalent to hibernate.cfg.xml's properties

				Properties settings = new Properties();

				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");

				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/empresa?useSSL=false");

				settings.put(Environment.USER, "root");

				settings.put(Environment.PASS, "");

				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

				settings.put(Environment.SHOW_SQL, "true");

				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

				configuration.setProperties(settings);

				configuration.addAnnotatedClass(Producto.class);
				configuration.addAnnotatedClass(Proveedor.class);
				configuration.addAnnotatedClass(Marca.class);
				configuration.addAnnotatedClass(MarcaPro.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()

						.applySettings(configuration.getProperties()).build();

				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				System.out.println("CONEXIÓN CON ÉXITO");
			} catch (Exception e) {

				e.printStackTrace();
				System.out.println("Conexión FALLIDA");
			}

		}

		return sessionFactory;

	}

	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}
}
