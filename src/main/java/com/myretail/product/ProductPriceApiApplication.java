package com.myretail.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;

@SpringBootApplication
@ConfigurationProperties

public class ProductPriceApiApplication {


	public static void main(String[] args) {
		SpringApplication.run(ProductPriceApiApplication.class, args);
	}
	
}
