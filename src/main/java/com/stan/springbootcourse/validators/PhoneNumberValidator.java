package com.stan.springbootcourse.validators;

import com.stan.springbootcourse.annotations.IsValidPhone;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<IsValidPhone, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext context) {
        if (s == null) {
            return true;
        }

        return (isValidLength(s)&&isNumeric(s));
    }

    public boolean isValidLength(String s) {
        return s.length() == 11;
    }

    public boolean isNumeric(String s) {
        return s.matches("\\d+");
    }
}
