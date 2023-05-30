package com.cinemaroomapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class CinemaRoomApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaRoomApiApplication.class, args);
	}

}
