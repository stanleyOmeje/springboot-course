package com.stan.springbootcourse.dsa;

public class Palindrome {

    public static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if(str.charAt(start) != str.charAt(end)) {
                System.out.println(str+" is not a palindrome" );
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("is MADAMY a palindrome: " +  isPalindrome("MADAMY"));

    }
}
