package com.github.atomfrede.jdconf_sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@SpringBootApplication
@EnableWebSocket
@Async
@EnableScheduling
public class JdconfSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdconfSampleApplication.class, args);
	}


}
