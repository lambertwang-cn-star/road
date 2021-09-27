package com.banlv.road.exception;

import com.banlv.road.HttpCode;

/**
 * @author ：Lambert Wang
 * @date ：Created in 2021/2/9 11:16
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
public class DataParseException extends BaseException {
    public DataParseException() {
    }

    public DataParseException(Throwable ex) {
        super(ex);
    }

    public DataParseException(String message) {
        super(message);
    }

    public DataParseException(String message, Throwable ex) {
        super(message, ex);
    }

    protected HttpCode getCode() {
        return HttpCode.INTERNAL_SERVER_ERROR;
    }
}
