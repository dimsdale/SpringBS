package ukr.dsa.config;

import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import ukr.dsa.SpringBsApplication;
import ukr.dsa.services.impl.ContactServiceImpl;
import ukr.dsa.services.impl.UserDetailsServiceImpl;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableWebMvc
@ComponentScan("ukr.dsa")
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = SpringBsApplication.class)
public class WebAppConfig extends WebMvcConfigurerAdapter implements TransactionManagementConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
    }

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        factory.setPort(8080);
        factory.setSessionTimeout(10, TimeUnit.MINUTES);
        return factory;
    }

    @Bean
    public UrlBasedViewResolver setViewResolver(){
        UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
        viewResolver.setPrefix("/pages/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    @Bean
    public UserDetailsServiceImpl userDetailsService(){
        return new UserDetailsServiceImpl();
    }

    @Bean
    public ContactServiceImpl contactService(){
        return new ContactServiceImpl();
    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new JpaTransactionManager();
    }


    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

}
