package com.tqt.javacommon.utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

/**
 * Posted from Jan 01, 2020, 7:51 PM
 *
 * @author Vi Quynh (vi.quynh.31598@gmail.com)
 */
public class Message {
    private Integer errCode;

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
    List<Message> ms = new LinkedList<>();
//    Map<Integer, List<Message>> studentGradeMap = ms.stream().collect(Collectors.groupingBy(Message::getErrCode));

}
