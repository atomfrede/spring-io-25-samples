package com.github.atomfrede.spring_io_25_samples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
public class WebsocketConfiguration implements WebSocketConfigurer {

    @Autowired
    WebsocketHolder websocketHolder;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(websocketHolder, "/websockets/ws", "/form/ws")
                .addInterceptors(new HttpSessionHandshakeInterceptor());
    }
}
