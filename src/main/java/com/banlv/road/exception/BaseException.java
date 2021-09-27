package com.banlv.road.exception;

import com.banlv.road.HttpCode;
import org.springframework.ui.ModelMap;

/**
 * @author ：Lambert Wang
 * @date ：Created in 2021/2/9 11:16
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
public abstract class BaseException extends RuntimeException {
    public BaseException() {

    }

    public BaseException(Throwable ex) {
        super(ex);
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable ex) {
        super(message, ex);
    }

    public void handler(ModelMap modelMap) {
        modelMap.put("code", this.getCode().value());
    }

    protected abstract HttpCode getCode();
}
