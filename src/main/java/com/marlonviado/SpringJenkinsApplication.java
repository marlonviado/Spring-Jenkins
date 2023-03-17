package com.marlonviado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJenkinsApplication {
	
	//public static Logger logger = (Logger) LoggerFactory.getLogger(SpringJenkinsApplication.class);

	public static void main(String[] args) {
		//logger.info("Running Main!!! Sample Spring Boot and Jenkins");
		System.out.println("MARLON VIADO");
		SpringApplication.run(SpringJenkinsApplication.class, args);
	}

}
