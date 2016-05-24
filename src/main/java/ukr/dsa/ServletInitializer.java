package ukr.dsa;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import ukr.dsa.config.SecurityConfig;
import ukr.dsa.config.WebAppConfig;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBsApplication.class);
	}

}
