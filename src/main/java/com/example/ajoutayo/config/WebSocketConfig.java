package com.example.ajoutayo.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    //private final StompHandler stompHandler;

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/sub"); //TODO: 구독 요청 prefix 넣기
        registry.setApplicationDestinationPrefixes("/pub"); //TODO: 메시지 발행 요청 prefix 넣기
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/bus/map") //클라이언트에서 웹소캣에 접속할 수 있는 endpoint
                .setAllowedOriginPatterns("*").withSockJS();
    }
    /*
    @Override
    public void configureClientInboundChannel (ChannelRegistration registration){
        registration.interceptors(stompHandler);
    }*/
}