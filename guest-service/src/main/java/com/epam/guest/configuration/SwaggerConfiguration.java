package com.epam.guest.configuration;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {
	@Bean
	public Docket guestServiceApiDock() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.epam.guestservice")).build();
	}
	
	private ApiInfo metaData() {
		return new ApiInfo("Guest-Service", "This Document contains the guest service api", "1.0", "urn:tos",
				new Contact("Sunku Dinesh Kumar", "URL", "sunku.dinesh9@gmail.com"), "Apache 2.0",
				"http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());
	}
}
