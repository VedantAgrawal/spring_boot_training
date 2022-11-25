package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatabaseServiceApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DatabaseServiceApplication.class, args);
	}

	private static final Logger log = LoggerFactory.getLogger(DatabaseServiceApplication.class);
	
	@Autowired
	BookRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repository.save(new Book("scala"));
		repository.save(new Book("cpp"));
		repository.save(new Book("c#"));
		repository.save(new Book("java"));
		
		log.info("Created Primary Record");
		
		System.out.println("Find all Records");
		
		repository.findAll().forEach(x->System.out.println(x));
	}

	
}
