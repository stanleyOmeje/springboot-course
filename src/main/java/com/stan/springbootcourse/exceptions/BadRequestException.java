package com.stan.springbootcourse.exceptions;

public class BadRequestException extends RuntimeException{
    String code;

    public BadRequestException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
