package ua.sdo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.sdo.config.SecurityConfig;
import ua.sdo.config.WebConfig;

@SpringBootApplication
public class SpringBsApplication {

	public static void main(String[] args) {
		SpringApplication.run(new Class<?>[]{SpringBsApplication.class, WebConfig.class, SecurityConfig.class}, args);
	}
}
