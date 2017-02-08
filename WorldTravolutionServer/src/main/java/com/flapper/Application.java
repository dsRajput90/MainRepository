package com.flapper;

import java.util.Arrays;

import org.apache.catalina.core.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;

@SpringBootApplication
public class Application  implements ApplicationListener<ContextRefreshedEvent> {
	private static final Logger LOG = LoggerFactory.getLogger(Application.class);
	
	@Value("${spring.profiles.active}")
    protected String springProfilesActive;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        LOG.info("=======================================");
        LOG.info("App running with active profiles: {}", springProfilesActive);
        LOG.info("=======================================");
    }
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		System.out.println("Let's inspect the beans provided by Spring Boot:");
		
		String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
	}
}
