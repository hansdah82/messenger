package com.myapp.messenger.dao.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.myapp.messenger.model.entity.Profile;

public class HibernateUtil {

	private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
				.applySettings(getDataSourceConfigSettings()).build();
		Metadata metadata = new MetadataSources(standardRegistry)
				.addAnnotatedClass(Profile.class)
				.getMetadataBuilder()
				.applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE).build();
		return metadata.getSessionFactoryBuilder().build();
	}

	private static Properties getDataSourceConfigSettings() {
		Properties props = new Properties();
		try (InputStream resourceAsStream = HibernateUtil.class.getClassLoader()
				.getResourceAsStream("datasource.properties");) {
			props.load(resourceAsStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return props;
	}

	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
	public static Session getNewSession() {
		return SESSION_FACTORY.openSession();
	}
	public static void close(Session session) {
		session.close();
	}

}
