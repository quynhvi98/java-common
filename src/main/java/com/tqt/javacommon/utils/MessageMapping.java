package com.tqt.javacommon.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Posted from Jan 01, 2020, 7:09 PM
 *
 * @author Vi Quynh (vi.quynh.31598@gmail.com)
 */
public class MessageMapping {

    public static Map<Integer, Integer> DVCMappingMICErrCode() {
        Map<Integer, Integer> messMap = new HashMap<>();
        messMap.put(MICMessage.SUCCESS.getVal(), DVCMessage.SUCCESS.getVal());
        messMap.put(MICMessage.FAIL.getVal(), DVCMessage.FAIL.getVal());
        return messMap;
    }

    public static Map<String, String> DVCMapping() {
        Map<String, String> messMap = new HashMap<>();
        messMap.put(String.valueOf(DVCMessage.SUCCESS.getVal()), DVCMessage.SUCCESS.getMs());
        messMap.put(String.valueOf(DVCMessage.FAIL.getVal()), DVCMessage.FAIL.getMs());
        return messMap;
    }

    public static Message mappingCodeProcess(Message message, Integer errCode, String mess) {
        Map<Integer, Integer> map = MessageMapping.DVCMappingMICErrCode();
        Map<String, String> mapMs = MessageMapping.DVCMapping();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getKey().equals(errCode)){
                message.setErrCode(entry.getValue());
            }
        }
        for (Map.Entry<String, String> e : mapMs.entrySet()) {
            if (e.getKey().equals(message.getErrCode())) {
                message.setMessage(e.getValue());
            }
        }
        return message;
    }
}
