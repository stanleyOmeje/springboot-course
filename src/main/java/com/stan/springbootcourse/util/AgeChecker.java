package com.stan.springbootcourse.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;

@Slf4j
public class AgeChecker {

        /**
         * Checks if a child is under 2 years old based on their date of birth.
         *
         * @param dobStr Date of birth in ISO format (e.g., "2023-08-01")
         * @return true if under 2 years old, false otherwise
         */
        public static boolean isPassengerAnInfant(String dobStr) {
            try {
                LocalDate dob = LocalDate.parse(dobStr); // Format: YYYY-MM-DD
                LocalDate today = LocalDate.now();
                if (dob.isAfter(today)) {
                    throw new IllegalArgumentException("Date of birth cannot be in the future.");
                }

                Period age = Period.between(dob, today);
                System.out.println("age "+age.getYears());
                return age.getYears() < 2;
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Invalid date format. Use 'YYYY-MM-DD'.", e);
            }
        }

    public static boolean isPassengerAChild(String dobStr) {
        try {
            LocalDate dob = LocalDate.parse(dobStr); // Format: YYYY-MM-DD
            LocalDate today = LocalDate.now();
            if (dob.isAfter(today)) {
                throw new IllegalArgumentException("Date of birth cannot be in the future.");
            }

            Period age = Period.between(dob, today);
            System.out.println("age "+age.getYears());
            return age.getYears() < 12;
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Use 'YYYY-MM-DD'.", e);
        }
    }

    public static String generateCorrelationId(){
        String correlationID = System.currentTimeMillis() + StringUtils.EMPTY + RandomStringUtils.randomNumeric(5);
        log.info("correlationID inside generateCorrelationId method is...{} and lenght ...{}",correlationID, correlationID.length());
        return correlationID;
    }

        // Sample usage
        public static void main(String[] args) {
            //String dob = "2024-10-01"; //2002-07-13T08:12:38.000Z
            String dob = "2015-07-13";

            System.out.println("Age check "+isPassengerAChild(dob));

            if (isPassengerAChild(dob)) {
                System.out.println("Child is under 12 years old.");
            } else {
                System.out.println("Child is 12 years or older.");
            }
            generateCorrelationId();
        }


}
