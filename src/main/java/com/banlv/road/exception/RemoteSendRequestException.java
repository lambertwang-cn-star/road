package com.banlv.road.exception;

import com.banlv.road.HttpCode;

/**
 * @author ：Lambert Wang
 * @date ：Created in 2021/8/12 10:04
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
public class RemoteSendRequestException extends BaseException  {
    public RemoteSendRequestException() {
    }

    public RemoteSendRequestException(Throwable ex) {
        super(ex);
    }

    public RemoteSendRequestException(String message) {
        super(message);
    }

    public RemoteSendRequestException(String message, Throwable ex) {
        super(message, ex);
    }

    @Override
    protected HttpCode getCode() {
        return HttpCode.INTERNAL_SERVER_ERROR;
    }
}
