package com.github.atomfrede.spring_io_25_samples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@SpringBootApplication
@EnableWebSocket
@Async
@EnableScheduling
public class SpringIO25SampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringIO25SampleApplication.class, args);
	}


}
