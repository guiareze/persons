package br.com.guiareze.persons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PersonsApplication {

	static void main(String[] args) {
		SpringApplication.run(PersonsApplication.class, args);
	}

}
