package com.thphuc.system.util;

import java.sql.Date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;


public class DateUtil {

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




    public static void main(String[] args) {
        System.out.println(getMondayOfCurrentWeek());
        System.out.println(getSundayOfCurrentWeek());
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
