package com.tqt.javacommon.rest;

import com.tqt.javacommon.utils.ApiLogger;
import com.tqt.javacommon.utils.Message;
import com.tqt.javacommon.utils.MessageMapping;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;

@Controller("/hello")
public class HelloMicroNaunt {

    private final ApiLogger logging = new ApiLogger(this.getClass());

    @Get("/")
    public Message index(@QueryValue Integer errCode, @QueryValue String mess ) {
        Message message = new Message();
        Message ms = MessageMapping.mappingCodeProcess(message, errCode, mess);
        logging.info("Message response", message);
        return ms;
    }
}