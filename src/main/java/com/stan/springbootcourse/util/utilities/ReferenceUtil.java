package com.stan.springbootcourse.util.utilities;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

public class ReferenceUtil {
    public static String generateInternalReference(){
        return System.currentTimeMillis() + StringUtils.EMPTY + RandomStringUtils.randomNumeric(3);
    }
}
