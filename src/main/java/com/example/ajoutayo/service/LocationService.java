package com.example.ajoutayo.service;

import com.example.ajoutayo.exceptions.CommonErrorCode;
import com.example.ajoutayo.exceptions.CustomApiException;
import com.example.ajoutayo.util.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LocationService {
    private final RedisUtil redisUtil;
    public List<?> getAllLocations() {
       //String value = redisUtil.getData();
        return null;
    }

    private void setAllLocations(){
        //redisUtil.setDataExpire(, , 60 * 60L);
    }

    public String getLocation(Long id) {
        String value = redisUtil.getData(String.valueOf(id));
        if(value==null){
            throw new CustomApiException(CommonErrorCode.BAD_REQUEST);
        }
        return value;
    }
}
