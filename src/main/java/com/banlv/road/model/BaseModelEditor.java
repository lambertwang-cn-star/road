package com.banlv.road.model;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ：Lambert Wang
 * @date ：Created in 2021/2/10 9:40
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
public class BaseModelEditor extends PropertyEditorSupport {
    private String format;

    public BaseModelEditor(String format) {
        this.format = format;
    }

    public Date transferUnix(long unix) {
        if (unix == 0L) {
            return new Date();
        }
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            return format.parse(String.valueOf(unix));
        } catch (ParseException e) {
            return null;
        }
    }

    public void setAsDate(BaseModel baseObj) {
        if (format != null && format.equals("date")) {
            baseObj.setCreateDate(this.transferUnix(baseObj.getCreateTime()));
            baseObj.setUpdateDate(this.transferUnix(baseObj.getUpdateTime()));
        }
    }
}
