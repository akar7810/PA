package com;

import java.text.*;
import java.time.*;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
import java.util.*;

public class Info {

    public static void displayInfo(Locale locale) {

        List<String> weekdays=new ArrayList<String>();

        System.out.println(locale.getDisplayCountry());
        System.out.println(locale.getDisplayLanguage());

        Currency currency = Currency.getInstance(locale);
        System.out.println(currency.getDisplayName());

        WeekFields wf = WeekFields.of(locale);
        DayOfWeek day = wf.getFirstDayOfWeek();
        for (int i = 0; i < DayOfWeek.values().length; i++) {
            weekdays.add(day.getDisplayName(TextStyle.FULL, locale));
            day = day.plus(1);
        }
        System.out.println(weekdays);

        DateFormatSymbols dfs = new DateFormatSymbols(locale);
        String[] months = dfs.getMonths();
        System.out.println(Arrays.toString(months));

        DateFormat date = DateFormat.getDateInstance(DateFormat.LONG, locale);
        System.out.println(date.format(new Date()));

        System.out.println("\n");


    }
}