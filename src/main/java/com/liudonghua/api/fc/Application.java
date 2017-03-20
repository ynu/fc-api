package com.liudonghua.api.fc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.liudonghua.api.fc.util.JwtFilter;

@SpringBootApplication
public class Application {
	
	@Bean
    public FilterRegistrationBean jwtFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter());
        registrationBean.addUrlPatterns("/site/*");
        return registrationBean;
    }
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}