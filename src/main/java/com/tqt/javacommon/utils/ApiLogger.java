package com.tqt.javacommon.utils;

import com.tqt.javacommon.utils.exception.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ApiLogger {
    private static String ipAddress;

    static {
        try {
            // IP address settings
            InetAddress address = InetAddress.getLocalHost();
            ipAddress = address.getHostAddress();
            System.setProperty("Ip.Address", address.getHostAddress());
        } catch (UnknownHostException e) {
            ApiLogger log = new ApiLogger(ApiLogger.class);
            log.error(ExceptionUtil.getStackTrace(e));
            ipAddress = "Unknown IP";
            System.setProperty("Ip.Address", "unknownIp");
        }
    }

    private Logger logger = null;

    /**
     * constructor
     *
     * @param callClass class name for log output
     */
    public ApiLogger(Class<?> callClass) {
        logger = LoggerFactory.getLogger(callClass);
    }

    public void info(String message) {
        if (logger.isInfoEnabled()) {
            logger.info(outputCreator(message));
        }
    }

    public void info(String message, Object... arguments) {
        if (logger.isInfoEnabled()) {
            logger.info(outputCreator(message), arguments);
        }
    }


    public void warn(String message) {
        if (logger.isWarnEnabled()) {
            logger.warn(outputCreator(message));
        }
    }

    public void warn(String message, Object... arguments) {
        if (logger.isWarnEnabled()) {
            logger.warn(outputCreator(message), arguments);
        }
    }

    public void debug(String message) {
        if (logger.isDebugEnabled()) {
            logger.debug(outputCreator(message));
        }
    }

    public void error(String message) {
        if (logger.isErrorEnabled()) {
            logger.error(outputCreator(message));
        }
    }

    public void error(String message, Object... arguments) {
        if (logger.isErrorEnabled()) {
            logger.error(outputCreator(message), arguments);
        }
    }

    private String outputCreator(String message) {
        RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean();
        String getProcessName = bean.getName();
        long getProcessID = Long.parseLong(getProcessName.split("@")[0]);

        MDC.put("ip", ipAddress);
        MDC.put("pid", getProcessID + "");

        return message;
    }
}
