package com.stan.springbootcourse.util;

import com.stan.springbootcourse.enums.TransactionStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Checks {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        float c = 7.1f;
        float d = 7.0f;
        double e = 7.05;
        double f = 7.01;
        System.out.println("a == b"+ (a == b));
        System.out.println("c == d"+ (c == d));
        System.out.println("Float "+Float.compare(c,d));
        System.out.println("Double "+Double.compare(e,f));

        List<TransactionStatus> status = new ArrayList<>(List.of(TransactionStatus.TRANSACTION_FAILED, TransactionStatus.SUCCESS));
        Collections.shuffle(status);
        TransactionStatus x = status.get(0);
        System.out.println("Shuffled transaction is "+x);
    }

}
