package com.thphuc.system.util;

import java.sql.Date;
import java.util.Calendar;

public class DateUtil {

    public static Date getMondayOfCurrentWeek() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        java.util.Date date = calendar.getTime();
        return new Date(date.getTime());
    }

    public static Date getSundayOfCurrentWeek() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(System.currentTimeMillis()));
        calendar.add(Calendar.DATE, 2);
        java.util.Date date = calendar.getTime();
        return new Date(date.getTime());
    }

    public static Date findSunday(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int daysToSunday = 8 - dayOfWeek;
        calendar.add(Calendar.DAY_OF_MONTH, daysToSunday);
        Date sundayDate = new Date(calendar.getTimeInMillis());
        return sundayDate;
    }

    public static void main(String[] args) {
    }
}
