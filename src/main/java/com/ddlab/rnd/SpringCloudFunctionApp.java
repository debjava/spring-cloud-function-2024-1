package com.ddlab.rnd;

import java.time.Duration;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class SpringCloudFunctionApp {

	@Bean
	public Function<String, String> uppercase() {
		return value -> value.toUpperCase();
	}

	@Bean
	public Supplier<Flux<String>> infinite() {
		return () -> Flux.interval(Duration.ofSeconds(1)).log().map(counter -> String.format("Counter: %s", counter));
	}
	
	@Bean
	public Supplier<String> hello() {
		return () -> "hello";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFunctionApp.class, args);
//		 SpringApplication.run(SampleApplication.class, "--management.endpoints.web.exposure.include=functions");

	}

}
