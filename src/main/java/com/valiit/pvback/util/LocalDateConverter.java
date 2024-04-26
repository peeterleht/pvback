package com.valiit.pvback.util;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class LocalDateConverter {

    public static Integer
    getWeekNumberFromSystemDate() {
        LocalDate now = LocalDate.now();
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        return now.get(weekFields.weekOfWeekBasedYear());
    }
}
