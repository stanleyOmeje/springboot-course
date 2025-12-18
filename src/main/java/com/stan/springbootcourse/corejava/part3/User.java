package com.stan.springbootcourse.corejava.part3;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class User implements Comparable<User>{
    private String username;
    private String password;
    private String email;
    private int age;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User(String username, String password, String email, int age) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
    }

    @Override
    public int compareTo(User o) {
       // return this.username.compareTo(o.username);
        return this.age-o.age;
    }

    public static void main(String[] args) {
        User a = new User("stan1","1234","stan1.com");
        User b = new User("stan2","1234","stan2.com");
        User c = new User("stan3","1234","stan3.com");

        Map<String, User> userMap= new HashMap<>();
        userMap.put(a.getUsername(),a);
        userMap.put(b.getUsername(),b);
        userMap.put(c.getUsername(),c);

        System.out.println(userMap);
        System.out.println(";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;");

        for (Map.Entry<String, User> entry : userMap.entrySet()) {
            System.out.println(entry.getKey());
        }
        System.out.println("###################################");
        for (Map.Entry<String, User> entry : userMap.entrySet()) {
            System.out.println(entry);
        }
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        for (var username : userMap.keySet()) {
            System.out.println(username);
        }
        System.out.println("111111111111111111111111111111111111111111111");
        for (User value: userMap.values()) {
            System.out.println(value);
        }
    }
}
