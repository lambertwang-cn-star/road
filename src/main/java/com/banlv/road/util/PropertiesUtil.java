package com.banlv.road.util;

import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;

/**
 * @author ：Lambert Wang
 * @date ：Created in 2021/2/9 14:28
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
public final class PropertiesUtil {
    private static Map<String, String> ctxPropertiesMap = new HashMap();

    public PropertiesUtil() {
    }

    public static Map<String, String> getProperties() {
        return ctxPropertiesMap;
    }

    public static String getString(String key) {
        try {
            return (String)ctxPropertiesMap.get(key);
        } catch (MissingResourceException var2) {
            return null;
        }
    }

    public static String getString(String key, String defaultValue) {
        try {
            String value = (String)ctxPropertiesMap.get(key);
            return DataUtil.isEmpty(value) ? defaultValue : value;
        } catch (MissingResourceException var3) {
            return defaultValue;
        }
    }

    public static Integer getInt(String key) {
        String value = (String)ctxPropertiesMap.get(key);
        return DataUtil.isEmpty(value) ? null : Integer.parseInt(value);
    }

    public static int getInt(String key, int defaultValue) {
        String value = (String)ctxPropertiesMap.get(key);
        return DataUtil.isEmpty(value) ? defaultValue : Integer.parseInt(value);
    }

    public static long getLong(String keyName, long defaultValue) {
        String value = getString(keyName);
        if (DataUtil.isEmpty(value)) {
            return defaultValue;
        } else {
            try {
                return Long.parseLong(value.trim());
            } catch (Exception var5) {
                return defaultValue;
            }
        }
    }

    public static boolean getBoolean(String key) {
        String value = (String)ctxPropertiesMap.get(key);
        return DataUtil.isEmpty(value) ? false : Boolean.parseBoolean(value.trim());
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        String value = (String)ctxPropertiesMap.get(key);
        return DataUtil.isEmpty(value) ? defaultValue : Boolean.parseBoolean(value.trim());
    }
}
