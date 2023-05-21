package com.example.ajoutayo.service;

import com.example.ajoutayo.config.WebSocketBroadcaster;
import com.example.ajoutayo.exceptions.CustomApiException;
import com.example.ajoutayo.exceptions.LocationErrorCode;
import com.example.ajoutayo.util.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

@Service
@RequiredArgsConstructor
@EnableScheduling
public class WebSocketService {
    private final RedisUtil redisUtil;
    private final WebSocketBroadcaster webSocketBroadcaster;

    @Scheduled(fixedDelay = 10000) // 10초마다 실행
    public void Scheduler(){
        Collection<String> list = Arrays.asList("bus01", "bus02","bus03");
        redisUtil.getAllData(list);
        list.forEach(s->getBusLocation(s, redisUtil.getData(s)));
    }
    public void getBusLocation(String key, String value){

        if(value==null){
            throw new CustomApiException(LocationErrorCode.BUS_NOT_FOUND);
        }

        String[] fields = value.split(",");

        //유닉스 타임 -> 타임스탬프 변환
        long timestamp = Long.parseLong(fields[0]);
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        Date date = new Date();
        date.setTime(timestamp);
        fields[0] = sdf.format(date);

        String locationMessage = Arrays.toString(fields);
        webSocketBroadcaster.broadcast(key+locationMessage);
    }

}
