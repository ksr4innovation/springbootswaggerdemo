package com.snkit.springbootswaggerdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.*;

@Configuration
@EnableSwagger2
public class SwaggerDemoConfiguration {
	
	ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("CUST")
				.description("This is Swagger Demo")
				.license("")
				.licenseUrl("")
				.termsOfServiceUrl("")
				.version("1.0.0-SNAPSHOT")
				.contact(new Contact("MicroDemoTeam","",""))
				.build();
	}
	
	@Bean
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
		
	}
}
