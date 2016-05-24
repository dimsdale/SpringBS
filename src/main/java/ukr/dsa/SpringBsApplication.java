package ukr.dsa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ukr.dsa.config.SecurityConfig;
import ukr.dsa.config.WebAppConfig;

@SpringBootApplication
public class SpringBsApplication {

	public static void main(String[] args) {
		SpringApplication.run(new Class<?>[]{SpringBsApplication.class, WebAppConfig.class, SecurityConfig.class}, args);
	}
}
