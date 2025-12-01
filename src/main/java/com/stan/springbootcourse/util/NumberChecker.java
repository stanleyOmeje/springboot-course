package com.stan.springbootcourse.util;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NumberChecker {
    public static boolean isNumber(Object input) {
        if (input == null) {
            return false;
        }

        return input instanceof Integer || input instanceof Long || input instanceof Double;
    }

    public static boolean isNumericString(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }

        try {
            // Try parsing as Integer
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e1) {
            try {
                // Try parsing as Long
                Long.parseLong(input);
                return true;
            } catch (NumberFormatException e2) {
                try {
                    // Try parsing as Double
                    Double.parseDouble(input);
                    return true;
                } catch (NumberFormatException e3) {
                    return false;
                }
            }
        }
    }

    private static boolean isPositiveNumber(String input) {
        log.info("Inside positive method");
        boolean isNum = isNumericString(input);
        if (isNum) {
            double num = Double.parseDouble(input);
            return num > 0.0;
        }
        return false;
    }

    public static void main(String[] arg) {
        Request request = new Request();
        request.setInput("10");
        System.out.println(isPositiveNumber(request.getInput()));
    }

    @Data
    public static class Request {
       String input;
    }

}
