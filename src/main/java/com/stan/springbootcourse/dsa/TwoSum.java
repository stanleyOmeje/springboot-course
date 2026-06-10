package com.stan.springbootcourse.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    public static Integer[] checkTwoSum(List<Integer> list, int target) {
        Map<Integer, Integer> seen = new HashMap<Integer, Integer>();
        for (int i = 0; i < list.size(); i++) {
            int diff = target - list.get(i);
            if (seen.containsKey(diff)) {
                return new Integer[]{seen.get(diff), i};
            }
            seen.put(list.get(i), i);
        }
        return new Integer[0];
    }

    public static void main(String[] args) {
        List<Integer> values = List.of(3,2,5,7,11,15);
        Integer[] arr = checkTwoSum(values, 12);
        System.out.println("========================");
        System.out.println(Arrays.toString(arr));
    }
}
