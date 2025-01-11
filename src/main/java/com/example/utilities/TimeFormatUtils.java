package com.example.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class TimeFormatUtils {
    public static String getFullFormatMonth(String month) throws ParseException {
        SimpleDateFormat oldMonthFormat = new SimpleDateFormat("MM", Locale.US);
        SimpleDateFormat newMonthFormat = new SimpleDateFormat("MMMMM", Locale.US);
        List<String> newFormatDate = List.of(newMonthFormat.format(oldMonthFormat.parse(month)).split(" "));
        return newFormatDate.getFirst();
    }
}
