package com.example.csit321g2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.example.csit321g2")
@EnableJpaRepositories(basePackages = "com.example.csit321g2.repository")
@EntityScan(basePackages = "com.example.csit321g2.entity")
@SpringBootApplication
public class Csit321g2Application {
	public static void main(String[] args) {
		SpringApplication.run(Csit321g2Application.class, args);
	}

}
