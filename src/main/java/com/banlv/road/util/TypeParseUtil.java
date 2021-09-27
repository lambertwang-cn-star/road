package com.banlv.road.util;

import com.banlv.road.exception.DataParseException;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author ：Lambert Wang
 * @date ：Created in 2021/2/9 11:09
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
public class TypeParseUtil {

    private TypeParseUtil() {
    }

    public static final Object convert(Object value, Class<?> type, String format) {
        return convert(value, type.getName(), format);
    }

    public static final Object convert(Object value, String type, String format) {
        Locale locale = Locale.getDefault();
        if(value == null){
            return null;
        } else if(!value.getClass().getName().equalsIgnoreCase(type) && value.getClass().getSimpleName().equalsIgnoreCase(type)) {
            if(!"Object".equalsIgnoreCase(type) && !"java.lang.Object".equals(type)) {
                if(value instanceof String) {
                    return string2Object(value, type, format, locale);
                } else {
                    return value.toString();
                }
            } else {
                return value;
            }
        } else {
            return value;
        }
    }

    private static Object string2Object(Object value, String type, String format, Locale locale) {
        String fromType = "String";
        String str = (String)value;

        try {
            if (!"String".equalsIgnoreCase(type) && !"java.lang.String".equalsIgnoreCase(type)) {
                if (str.length() == 0) {
                    return null;
                } else if (!"Boolean".equalsIgnoreCase(type) && !"java.lang.Boolean".equals(type)) {
                    Number tempNum;
                    if (!"Double".equalsIgnoreCase(type) && !"java.lang.Double".equalsIgnoreCase(type)) {
                        if (!"BigDecimal".equalsIgnoreCase(type) && !"java.math.BigDecimal".equalsIgnoreCase(type)) {
                            if (!"Float".equalsIgnoreCase(type) && !"java.lang.Float".equalsIgnoreCase(type)) {
                                NumberFormat nf;
                                Number df;
                                if (!"Long".equalsIgnoreCase(type) && !"java.lang.Long".equalsIgnoreCase(type)) {
                                    if (!"Integer".equalsIgnoreCase(type) && !"java.lang.Integer".equalsIgnoreCase(type)) {
                                        SimpleDateFormat sdf;
                                        if (!"Date".equalsIgnoreCase(type) && !"java.util.Date".equalsIgnoreCase(type)) {
                                            Date fieldDate;
                                            DateFormat dateFormat;
                                            if ("java.sql.Date".equalsIgnoreCase(type)) {
                                                if (format != null && format.length() != 0) {
                                                    sdf = new SimpleDateFormat(format);
                                                    fieldDate = sdf.parse(str);
                                                    return new java.sql.Date(fieldDate.getTime());
                                                } else {
                                                    try {
                                                        return java.sql.Date.valueOf(str);
                                                    } catch (Exception var11) {
                                                        try {
                                                            dateFormat = null;
                                                            if (locale != null) {
                                                                dateFormat = DateFormat.getDateInstance(3, locale);
                                                            } else {
                                                                dateFormat = DateFormat.getDateInstance(3);
                                                            }

                                                            fieldDate = dateFormat.parse(str);
                                                            return new java.sql.Date(fieldDate.getTime());
                                                        } catch (ParseException var10) {
                                                            throw new DataParseException(String.format("Could not convert %1$s to %2$s", str, type), var11);
                                                        }
                                                    }
                                                }
                                            } else if (!"Timestamp".equalsIgnoreCase(type) && !"java.sql.Timestamp".equalsIgnoreCase(type)) {
                                                throw new DataParseException(String.format("Convert from %1$s to %2$s not currently supported", fromType, type));
                                            } else {
                                                if (str.length() == 10) {
                                                    str = str + " 00:00:00";
                                                }

                                                if (format != null && format.length() != 0) {
                                                    try {
                                                        sdf = new SimpleDateFormat(format);
                                                        fieldDate = sdf.parse(str);
                                                        return new Timestamp(fieldDate.getTime());
                                                    } catch (ParseException var12) {
                                                        throw new DataParseException(String.format("Could not convert %1$s to %2$s", str, type), var12);
                                                    }
                                                } else {
                                                    try {
                                                        return Timestamp.valueOf(str);
                                                    } catch (Exception var13) {
                                                        try {
                                                            dateFormat = null;
                                                            if (locale != null) {
                                                                dateFormat = DateFormat.getDateTimeInstance(3, 3, locale);
                                                            } else {
                                                                dateFormat = DateFormat.getDateTimeInstance(3, 3);
                                                            }

                                                            fieldDate = dateFormat.parse(str);
                                                            return new Timestamp(fieldDate.getTime());
                                                        } catch (ParseException var9) {
                                                            throw new DataParseException(String.format("Could not convert %1$s to %2$s", str, type), var13);
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            if (format == null || format.length() == 0) {
                                                String separator = String.valueOf(str.charAt(4));
                                                StringBuilder pattern;
                                                if (separator.matches("\\d*")) {
                                                    pattern = new StringBuilder("yyyyMMdd HH:mm:ss");
                                                    format = pattern.substring(0, str.length());
                                                } else {
                                                    pattern = (new StringBuilder("yyyy")).append(separator).append("MM").append(separator).append("dd HH:mm:ss");
                                                    format = pattern.substring(0, str.length());
                                                }
                                            }

                                            sdf = new SimpleDateFormat(format);
                                            return sdf.parse(str);
                                        }
                                    } else {
                                        nf = getNf(locale);
                                        nf.setMaximumFractionDigits(0);
                                        df = nf.parse(str.replaceAll(",", ""));
                                        return new Integer(df.toString());
                                    }
                                } else {
                                    nf = getNf(locale);
                                    nf.setMaximumFractionDigits(0);
                                    df = nf.parse(str.replaceAll(",", ""));
                                    return new Long(df.toString());
                                }
                            } else {
                                tempNum = getNf(locale).parse(str.replaceAll(",", ""));
                                return new Float(tempNum.toString());
                            }
                        } else {
                            BigDecimal retBig = new BigDecimal(str.replaceAll(",", ""));
                            int iscale = str.indexOf(".");
                            int keylen = str.length();
                            if (iscale > -1) {
                                iscale = keylen - (iscale + 1);
                                return retBig.setScale(iscale, 5);
                            } else {
                                return retBig.setScale(0, 5);
                            }
                        }
                    } else {
                        tempNum = getNf(locale).parse(str.replaceAll(",", ""));
                        return new Double(tempNum.toString());
                    }
                } else {
                    return str.equalsIgnoreCase("TRUE") ? new Boolean(true) : new Boolean(false);
                }
            } else {
                return value;
            }
        } catch (Exception var14) {
            throw new DataParseException(String.format("Could not convert %1$s to %2$s", str, type), var14);
        }
    }

    private static NumberFormat getNf(Locale locale) {
        NumberFormat nf = null;
        if (locale == null) {
            nf = NumberFormat.getNumberInstance();
        } else {
            nf = NumberFormat.getNumberInstance(locale);
        }

        nf.setGroupingUsed(false);
        return nf;
    }
}
