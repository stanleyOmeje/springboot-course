package com.stan.springbootcourse.util;

import org.springframework.stereotype.Component;

@Component
public class PhoneNumberUtil {

    public static String parsePhoneNumber(String phoneNumber) {
        String phonenumber = "";
        try {
            // Remove any non-digit characters
            String digitsOnly = phoneNumber.replaceAll("\\D", "");

            // Ensure it starts with 0 and is 11 digits
            if (digitsOnly.startsWith("234") && digitsOnly.length() == 13) {
                return digitsOnly;
            } else if (digitsOnly.startsWith("0") && digitsOnly.length() == 11) {
                // Replace leading 0 with 234 (Nigeria's country code)
                phonenumber = "234" + digitsOnly.substring(1);
                //return "234" + digitsOnly.substring(1);
                return phonenumber;
            }
//            else
//
//            // If it's already in correct format or invalid, return as is or throw error
//            {
//                throw new IllegalArgumentException("Invalid Nigerian phone number format.");
//            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("Invalid phone number format.");
    }

    public static void main(String[] arg) {
       // PhoneNumberUtil phoneNumberUtil = new PhoneNumberUtil();
        System.out.println(PhoneNumberUtil.parsePhoneNumber("+234-90-78-51-24-86"));
    }

    // 07045623654,
    //08025871233,
    // 08164589212,
    //09078512486,
    //09154129654

}
