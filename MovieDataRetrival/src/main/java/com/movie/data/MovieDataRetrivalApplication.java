package com.movie.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//@EnableJpaRepositories(basePackages = "com.movie.data.repository")
@SpringBootApplication
public class MovieDataRetrivalApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieDataRetrivalApplication.class, args);
	}

}
