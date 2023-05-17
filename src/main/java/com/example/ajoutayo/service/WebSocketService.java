package com.example.ajoutayo.service;

import com.example.ajoutayo.exceptions.CustomApiException;
import com.example.ajoutayo.exceptions.LocationErrorCode;
import com.example.ajoutayo.util.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class WebSocketService {
    private final RedisUtil redisUtil;

    public String getBusLocation(String key){
        String value = redisUtil.getData(key);
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
        //BusLocationResponseDto location = new BusLocationResponseDto(x, y, time);


        return locationMessage;
    }

}
