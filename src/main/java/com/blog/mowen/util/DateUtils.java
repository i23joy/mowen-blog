package com.blog.mowen.util;

import java.time.LocalDateTime;

public class DateUtils {
    public static final String DF_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static String nowLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.toString();
    }
}
