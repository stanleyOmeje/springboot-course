package com.stan.springbootcourse.enums;

import lombok.Getter;

/**
 * Enum for lien API response status codes
 */
@Getter
public enum LienResponseStatus {
    SUCCESS("00", "Successful"),
    PENDING("01", "Pending - retry required"),
    FAILED("96", "Failed");

    private final String code;
    private final String description;

    LienResponseStatus(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static LienResponseStatus fromCode(String code) {
        for (LienResponseStatus status : values()) {
            if (status.code.equals(code)) {
                return status;
            }
        }
        return FAILED; // Default to failed for unknown codes
    }

    public static void main(String[] arg){
        System.out.println(LienResponseStatus.fromCode("00"));
    }

    public boolean isSuccess() {
        return this == SUCCESS;
    }

    public boolean isPending() {
        return this == PENDING;
    }

    public boolean isFailed() {
        return this == FAILED;
    }
}
