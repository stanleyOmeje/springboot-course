package com.stan.springbootcourse.corejava.part3.collections.iterables;

import java.util.*;

public class MainUser {
    public static void main(String[] args) {
     //   List<Users> list = new ArrayList<>();
        Users user1 = new Users("Mohn", "Doe", 23);
        Users user2 = new Users("Jane", "Williams", 25);
        Users user3 = new Users("zane", "Billiams", 25);
//        list.add(user1);
//        list.add(user2);
//        list.add(user3);
//        System.out.println(list);
//        System.out.println("==================================");
//        list.sort(new LastNameComparator());
//        System.out.println(list);

//        Queue<String> queue = new ArrayDeque<>();
//        queue.add("Mohn");
//        queue.add("Williams");
//        queue.add("Billiams");
//        String firstName = queue.poll();
//        System.out.println(firstName);
//        System.out.println(queue);

//        Set<String> s1 =  new HashSet<>(Arrays.asList("a","b","c","e"));
//        Set<String> s2 =  new HashSet<>(Arrays.asList("b","c","d"));
       // s1.addAll(s2); //Union
//        s1.retainAll(s2); // intercept
//        s1.removeAll(s2); //
//        System.out.println(s1);

        Map<String, Users> map = new HashMap<>();
        map.put(user1.getFirtName(), user1);
        map.put(user2.getFirtName(), user2);
        map.put(user3.getFirtName(), user3);

        //System.out.println(map.get(user1.getFirtName()));

        //System.out.println(map);

//        for (Map.Entry<String, Users> entry : map.entrySet()) {
//            if (entry.getKey().equals(user1.getFirtName())) {
//                System.out.println(entry);
//                break;
//            }
//            System.out.println(entry.getValue());
//
//        }
        for (Users user : map.values()) {
            System.out.println(user);
        }

    }
}
