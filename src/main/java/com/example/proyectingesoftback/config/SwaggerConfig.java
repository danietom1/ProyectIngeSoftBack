package com.example.proyectingesoftback.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket CasosApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				//.apis(RequestHandlerSelectors.basePackage("co.edu.poli.mongodb.controller")) //Specific package
				.apis(RequestHandlerSelectors.basePackage("com.example.proyectingesoftback")) //All project
				//.paths(PathSelectors.regex("/api/v1.*")) //filter RequestMapping with regular expression
				.paths(PathSelectors.any())
				.build()
				.apiInfo(UserApiInfo())
				.tags(new Tag("Class: CuestionarioController", "*** Cuestionario Controller ***"));
	}

	private ApiInfo UserApiInfo() {
		return new ApiInfoBuilder()
				.title("My Spring Boot REST API")
				.description("Customer REST API")
				.contact(new Contact("Contacto - Yesid Sanabria, Daniel Nieto y Julian Munar", "", "yesanabria2@poligran.edu.co;danietom1@poligran.edu.co;jumunara@poligran.edu.co"))
				.version("0.0.1")
				.build();
	}
}