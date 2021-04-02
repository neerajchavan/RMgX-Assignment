package com.assignment.rmgx;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class RmgxApplication {

	public static void main(String[] args) {
		SpringApplication.run(RmgxApplication.class, args);
	}

	@Bean
	 public Docket swaggerConfiguration() {
		 return new Docket(DocumentationType.SWAGGER_2)
				 .select()
				 .apis(RequestHandlerSelectors.basePackage("com.assignment.rmgx"))
				 .build()
		 		 .apiInfo(apiDetails());
	 }
	
	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Asset Management API",
				"Any company has assets like laptops, keyboard, stationary items, furniture etc. It is important for a company to keep a track of these assets, their condition,\n" + 
				"and assignment to people to ensure rightful use of these assets and keep a track of them. This API provides functionality for managing the assets of the company",
				"0.0.1", 
				"", 
				new springfox.documentation.service.Contact("Neeraj Chavan", "https://www.linkedin.com/in/neeraj-chavan-/", "chavan.n33raj@gmail.com"),
				"", 
				"",
				Collections.emptyList());
	}

}
