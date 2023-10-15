package com.thphuc.system.util;

import java.sql.Date;

import java.util.Calendar;


public class DateUtil {

    public static Date getMondayOfCurrentWeek() {
        Calendar calendar = Calendar.getInstance();
        java.util.Date currentDate = calendar.getTime();
        calendar.setTime(currentDate);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        calendar.add(Calendar.DATE, -6);
        java.sql.Date sqlDate = new java.sql.Date(calendar.getTime().getTime());
    return sqlDate;
    }



    public static Date getSundayOfCurrentWeek() {
        Date sundayDate = Date.valueOf(getMondayOfCurrentWeek().toLocalDate().plusDays(6));
        return sundayDate;
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


}
