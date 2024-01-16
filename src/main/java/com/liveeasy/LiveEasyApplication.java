package com.liveeasy;

import com.liveeasy.repository.LoadRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.liveeasy.entity")
@EnableJpaRepositories(basePackageClasses = LoadRepository.class)
public class LiveEasyApplication {
	public static void main(String[] args) {
		SpringApplication.run(LiveEasyApplication.class, args);
	}
}

