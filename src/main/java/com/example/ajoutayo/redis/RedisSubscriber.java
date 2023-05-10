package com.example.ajoutayo.redis;

import com.example.ajoutayo.dto.response.BusLocationResponseDto;
import com.example.ajoutayo.exceptions.CommonErrorCode;
import com.example.ajoutayo.exceptions.CustomApiException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Slf4j
@RequiredArgsConstructor
@Service
public class RedisSubscriber implements MessageListener { //실제 메시지를 처리하는 비즈니스 로직 담음
    private final ObjectMapper objectMapper;
    private final RedisTemplate redisTemplate;
    private final SimpMessageSendingOperations messagingTemplate;

    /**
     * Redis에서 메시지가 publish되면 대기하고 있던 onMessage가 해당 메시지를 받아 처리
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {
        try {
            // redis에서 발행된 데이터를 받아 역직렬화
            //String busId = new String(message.getChannel());
            String busId = (String) redisTemplate.getStringSerializer().deserialize(message.getChannel());
            String publishMessage = (String) redisTemplate.getStringSerializer().deserialize(message.getBody());
            //데이터 : (timestamp),37.28072,127.04351

            String[] fields = publishMessage.split(",");
            Timestamp time = Timestamp.valueOf(fields[0]);
            Double x = Double.parseDouble(fields[1]);
            Double y = Double.parseDouble(fields[2]);

            BusLocationResponseDto busLocationResponseDto = new BusLocationResponseDto(x,y,time);
            //messagingTemplate.convertAndSend("/topic/location", objectMapper.writeValueAsString(busLocationResponseDto));
            messagingTemplate.convertAndSend("/bus/" + busId + "/location", objectMapper.writeValueAsString(busLocationResponseDto));
        } catch (Exception e) {
            throw new CustomApiException(CommonErrorCode.NOT_FOUND);
        }
    }
}
