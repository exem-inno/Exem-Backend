package com.backend.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    public static String getMicroTime(Long time) {
        Long micro = time % 1000;
        Long ms = time / 1000;
        Date timeInDate = new Date(ms);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSS").format(timeInDate)+ " micro " + micro);
        return "";
    }
}
