package com.tqt.javacommon.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Posted from Jan 01, 2020, 7:09 PM
 *
 * @author Vi Quynh (vi.quynh.31598@gmail.com)
 */
public class MessageMapping {
    public static Map<Integer, Integer> mappingMessage(Integer errCode) {
        Map<Integer, Integer> messMap = new HashMap<>();
        messMap.put(DVCMessage.SUCCESS.getVal(), MICMessage.SUCCESS.getVal());
        messMap.put(DVCMessage.FAIL.getVal(), MICMessage.FAIL.getVal());
        return messMap;
    }
}
