package com.banlv.road.util;

import com.banlv.road.exception.DataParseException;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：Lambert Wang
 * @date ：Created in 2021/2/9 10:46
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
public final class InstanceUtil {
    protected static Logger logger = LogManager.getLogger();
    private static final Map<String, Field> fieldMap = newHashMap();

    private InstanceUtil() {

    }

    public static final <T> T to(Object orig, Class<T> clazz) {
        T bean = null;
        try {
            bean = clazz.newInstance();
            Class<?> cls = orig.getClass();
            BeanInfo orgInfo = Introspector.getBeanInfo(cls);
            PropertyDescriptor[] orgPty = orgInfo.getPropertyDescriptors();
            Map<String, PropertyDescriptor> propertyDescriptorMap = newHashMap();
            PropertyDescriptor[] var7 = orgPty;
            int var8 = orgPty.length;
            for (int var9 = 0; var9 < var8; var9++) {
                PropertyDescriptor property = var7[var9];
                propertyDescriptorMap.put(property.getName(), property);
            }

            BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            PropertyDescriptor[] var22 = propertyDescriptors;
            int var23 = propertyDescriptors.length;
            for (int var11 = 0; var11 < var23; ++var11) {
                PropertyDescriptor property = var22[var11];
                String key = property.getName();
                if (!"class".equals(key) && propertyDescriptorMap.containsKey(key)) {
                    Method getter = ((PropertyDescriptor) propertyDescriptorMap.get(key)).getReadMethod();
                    Object value = TypeParseUtil.convert(getter.invoke(orig), property.getPropertyType(), (String) null);
                    try {
                        String fieldName = clazz.getName() + "." + key;
                        Field field = (Field) fieldMap.get(fieldName);
                        if (field == null) {
                            field = clazz.getDeclaredField(key);
                            fieldMap.put(fieldName, field);
                        }
                        field.setAccessible(true);
                        field.set(bean, value);
                    } catch (Exception var18) {
                        PropertyUtils.setProperty(bean, key, value);
                    }
                }
            }
        } catch (Exception var19) {
            logger.error("toError" + var19);
        }
        return bean;
    }

    public static <T> T getDiff(T oldBean, T newBean) {
        if (oldBean == null && newBean != null) {
            return newBean;
        } else if (newBean == null) {
            return null;
        } else {
            Class cls1 = oldBean.getClass();
            try {
                T object = (T) cls1.newInstance();
                BeanInfo beanInfo = Introspector.getBeanInfo(cls1);
                PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
                PropertyDescriptor[] var1 = descriptors;
                int var2 = descriptors.length;
                for (int var3 = 0; var3 < var2; var3++) {
                    PropertyDescriptor descriptor = descriptors[var3];
                    String key = descriptor.getName();
                    if (!"class".equals(key)) {
                        Method getter = descriptor.getReadMethod();
                        Object oldValue = getter.invoke(oldBean);
                        Object newValue = getter.invoke(newBean);
                        if (newValue != null && !newValue.equals(oldValue)) {
                            Object value = TypeParseUtil.convert(newValue, descriptor.getPropertyType(), (String) null);
                            try {
                                String fieldName = cls1.getName() + "." + key;
                                Field field = (Field) fieldMap.get(fieldName);
                                if (field == null) {
                                    field = cls1.getDeclaredField(key);
                                    fieldMap.put(fieldName, field);
                                }
                                field.setAccessible(true);
                                field.set(object, value);
                            } catch (Exception var17) {
                                PropertyUtils.setProperty(object, key, value);
                            }
                        }
                    }
                }
                return object;
            } catch (Exception e) {
                throw new DataParseException(e);
            }
        }
    }

    public static final <E> ArrayList<E> newArrayList() {
        return new ArrayList<>();
    }

    public static final <k, v> HashMap<k, v> newHashMap() {
        return new HashMap<>();
    }
}
