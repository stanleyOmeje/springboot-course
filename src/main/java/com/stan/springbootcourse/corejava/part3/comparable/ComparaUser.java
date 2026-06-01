package com.stan.springbootcourse.corejava.part3.comparable;

import lombok.Data;

@Data
public class ComparaUser implements Comparable<ComparaUser>{
     int score;

    public ComparaUser(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(ComparaUser o) {
        return score - o.score;
    }

    public static void main(String[] args) {
        ComparaUser u1 = new ComparaUser(5);
        ComparaUser u2 = new ComparaUser(5);

        if (u1.compareTo(u2) > 0) {
            System.out.println("User 1 is greater than User 2");
        } else if (u1.compareTo(u2) < 0) {
            System.out.println("User 1 is lesser than User 2");
        }else {
            System.out.println("User 1 is equal to User 2");
        }
    }
}
