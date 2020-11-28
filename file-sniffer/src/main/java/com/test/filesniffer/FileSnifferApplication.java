package com.test.filesniffer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FileSnifferApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileSnifferApplication.class, args);
	}

}
