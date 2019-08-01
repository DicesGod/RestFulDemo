package com.minhle.webfulservice;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
CommandLineRunner runner (CourseRepository cRepository) {
	return args -> {
		Arrays.asList("iOS,Android,Java,Algorithm".split(","))
			.forEach(title -> {
				Course toSave = new Course();
				toSave.setCourseTitle(title);
				cRepository.save(toSave);
			});
	};
}
}
