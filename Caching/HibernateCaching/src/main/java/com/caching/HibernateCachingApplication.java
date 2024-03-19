package com.caching;

import com.caching.com.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateCachingApplication {

	public static void main(String[] args) {

		SpringApplication.run(HibernateCachingApplication.class, args);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();
		User user = session.get(User.class,1);
		System.out.println(user);


	}


}
