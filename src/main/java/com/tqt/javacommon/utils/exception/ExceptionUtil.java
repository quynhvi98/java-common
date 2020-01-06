package com.tqt.javacommon.utils.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtil {
    public static String getStackTrace(Throwable throwable) {
        try (
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw)
        ) {
            throwable.printStackTrace(pw);
            return sw.toString();
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}
