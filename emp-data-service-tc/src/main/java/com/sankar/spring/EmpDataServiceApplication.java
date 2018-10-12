package com.sankar.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class EmpDataServiceApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(EmpDataServiceApplication.class);
		
	}
	
	//On the regular servers, this main doesn't have any meaning.. works only when embedded tomcat is being used
	public static void main(String[] args) {
		SpringApplication.run(EmpDataServiceApplication.class, args);
	}
	
	public ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.description("Rest Doc for Emp Service Application")
				.license("Open License")
				.title("API Doc For Emp Service")
				.build()
					;
	}
	
	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.sankar.spring"))
				.build()
				.apiInfo(apiInfo())
				;
		
	}
}
