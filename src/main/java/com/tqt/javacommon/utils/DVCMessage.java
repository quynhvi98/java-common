package com.tqt.javacommon.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Posted from Jan 01, 2020, 7:10 PM
 *
 * @author Vi Quynh (vi.quynh.31598@gmail.com)
 */

public enum DVCMessage {
    SUCCESS(1, "Successful"),
    FAIL(2, "Fail");
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
}