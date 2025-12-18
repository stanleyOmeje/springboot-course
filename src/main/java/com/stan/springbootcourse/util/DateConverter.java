package com.stan.springbootcourse.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateConverter {
    public static String convertDateToIsoUtc(String dateStr) throws ParseException{
        // Convert Date to Instant
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(dateStr);
        Instant instant = date.toInstant();

        // Format as ISO 8601 UTC (with milliseconds and Z suffix)
        return DateTimeFormatter.ISO_INSTANT.format(instant);
    }

    // Example usage
    public static void main(String[] args) throws ParseException {
        Date now = new Date();
        String isoString = convertDateToIsoUtc("2024-02-19");
        System.out.println("ISO UTC Format: " + isoString);
    }
}
