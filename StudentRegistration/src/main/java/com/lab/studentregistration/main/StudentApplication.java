package com.lab.studentregistration.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@EnableConfigurationProperties
@EntityScan(basePackages = { "com.lab.studentregistration.entity" })
@ComponentScan(basePackages = "com.lab.studentregistration")
@EnableJpaRepositories("com.lab.studentregistration.repository")
public class StudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}

}
