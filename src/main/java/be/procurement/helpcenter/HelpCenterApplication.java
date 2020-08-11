package be.procurement.helpcenter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class HelpCenterApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(HelpCenterApplication.class);

    @Autowired
    private Environment env;

    @Override
    public void run(String... args) throws Exception {

        logger.info("Application environment: {}", env.getProperty("eproc.environment"));

    }	

	public static void main(String[] args) {
		SpringApplication.run(HelpCenterApplication.class, args);
    }
    
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**");
			}
		};
	}    

}
