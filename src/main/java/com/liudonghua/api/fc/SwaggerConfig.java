package com.liudonghua.api.fc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.useDefaultResponseMessages(false)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("FC-API Swagger Documentation")
				.description("FC-API Swagger Documentation")
				.termsOfServiceUrl("http://www.ynu.edu.cn")
				.contact("liudonghua123@gmail.com")
				.license("Apache License Version 2.0")
				.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
				.version("2.0")
				.build();
	}
	
	@Bean
	SecurityConfiguration security() {
		return new SecurityConfiguration(null, null, null, null, "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhcGkiLCJyb2xlcyI6WyJ1c2VyIiwiYWRtaW4iXSwiaWF0IjoxNDg5OTE0OTcyfQ.Q3vEjInIg8jlKHFCWnfz8CKIsST15MeGvulVWCO77jY", ApiKeyVehicle.HEADER, "Authorization", ",");
	}
}