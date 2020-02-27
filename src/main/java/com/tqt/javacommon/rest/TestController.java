package com.tqt.javacommon.rest;

import com.tqt.javacommon.utils.model.Sorting;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.validation.Validated;

import javax.validation.Valid;

@Controller("sample")
@Validated
public class TestController {

    @Get("/{?sorting*}")
    public String items(Sorting sorting) {
        System.out.println("aloha");
        return "";
    }
}
