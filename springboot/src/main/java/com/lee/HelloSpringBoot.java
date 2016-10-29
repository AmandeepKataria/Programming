package com.lee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HelloSpringBoot {
	
	
	public static void main(final String args[]){
		ApplicationContext ctx = SpringApplication.run(HelloSpringBoot.class, args);
		
	}
}
