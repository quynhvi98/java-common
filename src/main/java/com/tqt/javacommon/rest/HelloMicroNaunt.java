package com.tqt.javacommon.rest;

import com.tqt.javacommon.utils.Message;
import com.tqt.javacommon.utils.MessageMapping;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.QueryValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller("/hello")
public class HelloMicroNaunt {

    @Get("/")
    public Message index(@QueryValue Integer errCode, @QueryValue String mess ) {
        Message message = new Message();

        Map<Integer, Integer> map = MessageMapping.mappingMessage(errCode);

        for (Integer errorCode : map.keySet()){
            if (map.containsKey(errCode)){
                message.setErrCode(errorCode);
            }
        }
        return message;
    }
}