package com.library.libraryProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.library")
@EntityScan("com.library.model")
@EnableJpaRepositories("com.library.repository")
public class LibraryProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryProjectApplication.class, args);
	}

}
