package com.metrics.metric;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MetricApplication {

	public static void main(String[] args) {
		System.out.println(System.getProperty("java.class.path"));

		SpringApplication.run(MetricApplication.class, args);

	}
}
