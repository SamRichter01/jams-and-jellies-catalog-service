package com.jams_and_jellies.catalog_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.hibernate.cfg.Configuration;

import static java.lang.Boolean.TRUE;
import static java.lang.System.out;
//import static org.hibernate.cfg.AvailableSettings.*;

@SpringBootApplication
public class CatalogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogServiceApplication.class, args);
	
		var sessionFactory = new Configuration()
		.addAnnotatedClass(Jelly.class)
		.buildSessionFactory();

		sessionFactory.getSchemaManager().exportMappedObjects(true);
		
		sessionFactory.inTransaction(session -> {
			session.persist(new Jelly("1234567", "Grape"));
		});

		sessionFactory.inSession(session -> {
			out.println(session.createSelectionQuery("select stockNumber||': 'name from jelly").getSingleResult());
		});
	}
}