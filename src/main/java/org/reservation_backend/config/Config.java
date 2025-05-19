package org.reservation_backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Bean
	public OpenAPI easyTravelOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("EasyTravel API")
						.version("1.0.0")
						.description("Documentation des endpoints de l'application EasyTravel"));
	}
}
