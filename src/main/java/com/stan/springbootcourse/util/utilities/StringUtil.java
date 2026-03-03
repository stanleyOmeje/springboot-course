package com.stan.springbootcourse.util.utilities;

public class StringUtil {

    public static boolean isNotBlank(String str) {
        if (str == null) {
            return false;
        }

        return str.length() > 0;
    }
}
