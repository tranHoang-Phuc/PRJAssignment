package com.thphuc.system.util;

import java.sql.Date;

import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;


public class DateTimeUtil {

    public static Date getMondayOfCurrentWeek() {
        LocalDate today = LocalDate.now();
        DayOfWeek currentDayOfWeek = today.getDayOfWeek();
        int daysUntilMonday = DayOfWeek.MONDAY.getValue() - currentDayOfWeek.getValue();
        if (daysUntilMonday > 0) {
            today = today.minusDays(daysUntilMonday);
        }
        LocalDate monday = today.plusDays(daysUntilMonday);
        return Date.valueOf(monday);
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

    public static Time getCurrentSqlTime() {
        java.util.Date currentDate = new java.util.Date();
        Time currentTime = new Time(currentDate.getTime());
        return currentTime;
    }

    public static Date getCurrentSqlDate() {
        Calendar calendar = Calendar.getInstance();
        java.util.Date currentDate = calendar.getTime();
        Date currentSqlDate = new Date(currentDate.getTime());
        return currentSqlDate;
    }


}
