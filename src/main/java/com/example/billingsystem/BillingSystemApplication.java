package com.example.billingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main entry point for the Spring Boot Billing System application.
 *
 * @SpringBootApplication is a convenience annotation that adds:
 * - @Configuration: Tags the class as a source of bean definitions.
 * - @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings,
 * other beans, and various property settings (e.g., setting up a web server).
 * - @ComponentScan: Scans the current package and sub-packages for components (like @Controller,
 * @Service, @Repository) to automatically register them as Spring beans.
 */
@SpringBootApplication
public class BillingSystemApplication {

	/**
	 * The main method that runs the Spring Boot application.
	 *
	 * @param args Command line arguments passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(BillingSystemApplication.class, args);
	}

}
