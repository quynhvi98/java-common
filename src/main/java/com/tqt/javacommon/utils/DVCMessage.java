package com.tqt.javacommon.utils;

import java.util.*;

/**
 * Posted from Jan 01, 2020, 7:10 PM
 *
 * @author Vi Quynh (vi.quynh.31598@gmail.com)
 */

public enum DVCMessage {
    SUCCESS(1, "Thành công"),
    FAIL(2, "Thất bại");
    private int val;
    private String ms;
    DVCMessage(int val, String ms) {
        this.val = val;
        this.ms = ms;
    }

    private static final Map<Byte, DVCMessage> BY_VAL = new HashMap<>();
    private static final Map<Byte, String> STR_BY_VAL = new HashMap<>();

    static {
        for (DVCMessage value : values()) {
            BY_VAL.put((byte) value.val, value);
            STR_BY_VAL.put((byte) value.val, value.ms);
        }
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public String getMs() {
        return ms;
    }

    public void setMs(String ms) {
        this.ms = ms;
    }

    public static String getDescFromCode(Integer errCode) {
        for (DVCMessage errorCodes : DVCMessage.list()) {
            if (errorCodes.getVal() == errCode)
                return errorCodes.getMs();
        }
        return FAIL.getMs();
    }

    public static List<DVCMessage> list() {
        List<DVCMessage> list = new ArrayList<>();
        DVCMessage[] values = values();
        Collections.addAll(list, values);
        return list;
    }
}
