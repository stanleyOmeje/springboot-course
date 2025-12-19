package com.stan.springbootcourse.corejava.part3;

import lombok.Data;

@Data
public class ThreadStatus {
    int totalNumber;

    public void incrementNumber() {
        totalNumber++;
    }
}
