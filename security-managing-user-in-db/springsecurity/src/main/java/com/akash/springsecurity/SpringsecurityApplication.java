package com.akash.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*@EnableJpaRepositories("com.eazybytes.repository")
@EntityScan("com.eazybytes.model")*/
// @ComponentScan("com.akash.springsecurity.controller") //If using a different location from the main package, define the location here.
public class SpringsecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityApplication.class, args);
	}

}
