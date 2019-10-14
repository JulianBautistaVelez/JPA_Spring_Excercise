package com.julian.bootmvchibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.julian.bootmvchibernate.controller.UserFormatter;

@SpringBootApplication
public class BootmvchibernateApplication implements WebMvcConfigurer{
	
	 @SuppressWarnings("unchecked")
		@Override
	    public void addFormatters(FormatterRegistry registry) {
		  registry.addFormatter(new UserFormatter());
	    }
	 
	 

	public static void main(String[] args) {
		SpringApplication.run(BootmvchibernateApplication.class, args);
	}

}
