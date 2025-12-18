package com.stan.springbootcourse.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class DateValidatorUtils {
//    public DefaultApiResponse validateDates(String startDateStr, String endDateStr) {
//        DefaultApiResponse response = new DefaultApiResponse();
//
//        try {
//            // Parse dates using the specified format
//            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//            Date startDate = dateFormat.parse(startDateStr);
//            Date endDate = dateFormat.parse(endDateStr);
//
//            // Convert to Instant objects for further processing
//            Instant startInstant = startDate.toInstant();
//            Instant endInstant = endDate.toInstant();
//
//            // Get the current instant in the system's default time zone
//            Date today = new Date();
//            String format = dateFormat.format(today);
//            Date todayDate = dateFormat.parse(format);
//            Instant now = todayDate.toInstant();
//
//            if (startInstant.isBefore(now)) {
//                response.setStatus("99");
//                response.setMessage("Invalid start date: Start date cannot be earlier than today.");
//            } else if (startInstant.isAfter(endInstant)) {
//                response.setStatus("99");
//                response.setMessage("Invalid date range: Start date cannot be greater than end date.");
//            } else {
//                response.setStatus("00");
//                response.setMessage("Dates are valid.");
//            }
//        } catch (ParseException e) {
//            response.setStatus("99");
//            response.setMessage("Invalid date format: Please use dd/MM/yyyy format for both dates.");
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//
//        return response;
//    }

    public static String getTimeInMilli(String startDate, String endDate) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Long millisecondsStartDate = dateFormat.parse(startDate).getTime();
        Long millisecondsEndDate = dateFormat.parse(endDate).getTime();

        return millisecondsStartDate + "," + millisecondsEndDate;
    }

    // Convert milliseconds to date string
    public static String getDateFromMillis(long milliseconds) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date(milliseconds);
        return dateFormat.format(date);
    }

    // Convert milliseconds to date string with time
    public static String getDateTimeFromMillis(long milliseconds) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date(milliseconds);
        return dateFormat.format(date);
    }

    // Convert milliseconds to Date object
    public static Date getDateObjectFromMillis(long milliseconds) {
        return new Date(milliseconds);
    }

    public static long getTimeInMilli(String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Long millisecondsStartDate = dateFormat.parse(date).getTime();

        return millisecondsStartDate;
    }

    public static void main(String[] args) throws ParseException {
        // Convert to milliseconds
  //     String timeInMilli = getTimeInMilli("19/02/2024", "19/02/2024");
//        System.out.println("Time in milli: " + timeInMilli);

        // Convert your specific milliseconds back to date
        long millis = 1708376400000L;
     //   System.out.println("Date from millis: " + getDateFromMillis(millis));
        //System.out.println("DateTime from millis: " + getDateTimeFromMillis(millis));


        String dt = "2017-05-28 21:32:00";
      //  System.out.println("Date to millis: " + getTimeInMilli(dt));

        // Parse the comma-separated values and convert back
//        String[] times = timeInMilli.split(",");
//        System.out.println("Start Date: " + getDateFromMillis(Long.parseLong(times[0])));
//        System.out.println("End Date: " + getDateFromMillis(Long.parseLong(times[1])));

        System.out.println("isValidDateTime Check: " + isValidDateTime(dt));
    }

    public static boolean isValidDateTime(String dateTime) {
        if (dateTime == null || dateTime.trim().isEmpty()) {
            return false;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        try {
            LocalDateTime.parse(dateTime, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

}
