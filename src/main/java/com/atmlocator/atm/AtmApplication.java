package com.atmlocator.atm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.atmlocator.atm.domain","com.atmlocator.atm.controller"})
public class AtmApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtmApplication.class, args);
	}

}
