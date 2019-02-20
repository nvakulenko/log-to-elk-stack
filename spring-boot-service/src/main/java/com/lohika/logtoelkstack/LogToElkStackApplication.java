package com.lohika.logtoelkstack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogToElkStackApplication implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(LogToElkStackApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LogToElkStackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		MDC.put("tenant", "some-tenant");

		LOGGER.info("Application has started");
		try {
			throw new Exception("Test stacktrace in logs");
		} catch (Exception e) {
			LOGGER.error(e.getLocalizedMessage(), e);
		}
	}
}
