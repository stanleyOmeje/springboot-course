package com.stan.springbootcourse.calender;


import com.stan.springbootcourse.calender.dto.Bookings;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@Slf4j
public class Intervals {
    private TreeMap<Integer, Integer> bookings ;
    private List<Bookings> normalBookings   ;
    private List<Bookings> doubleBookings   ;

    public Intervals() {
        bookings = new TreeMap<>();
        normalBookings = new ArrayList<>();
        doubleBookings = new ArrayList<>();
    }

    public int getFloor(TreeMap<Integer, Integer> values, int key) {
        return values.floorKey(key);
    }

    public int getCeiling(TreeMap<Integer, Integer> values, int key) {
        return values.ceilingKey(key);
    }

    public boolean book( int start, int end) {
        Integer previousBooking = bookings.floorKey(start);
        Integer nextBooking = bookings.ceilingKey(end);
        if ((previousBooking == null || bookings.get(previousBooking) <= start) && (nextBooking == null || end <=nextBooking)) {
            bookings.put(start, end);
            System.out.println("Your booking "+bookings+" is successful");
            return true;
        }
        System.out.println("Your booking ("+start+","+end+") is not successful");
        return false;

    }

    public boolean doubleBook( int start, int end) {
        log.info("inside doubleBook method");
        for (Bookings doublebooking : doubleBookings) {
            log.info("inside doubleBook for loop");
            if (overlap(doublebooking.getStartPoint(), doublebooking.getEndPoint(), start, end)) {
                return false;
            }
        }
        for (Bookings booking : normalBookings) {
            if (overlap(booking.getStartPoint(), booking.getEndPoint(), start, end)) {
                doubleBookings.add(new Bookings(Math.max(booking.getStartPoint(), start), Math.min(booking.getEndPoint(), end)));
            }
        }
        normalBookings.add(new Bookings(start, end));
  return true;
    }

    public boolean overlap(Integer s1, Integer e1, Integer s2, Integer e2){
      return Math.max(s1,s2) < Math.min(e1,e2);
    }

    public char getChar(String val) {
        String validChars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_";
        char ch = ' ';
        for (int i = 0; i < val.length(); i++) {
            ch = val.charAt(val.length() - i - 1);
            System.out.println(ch);
            System.out.println(validChars.indexOf(ch));
        }
        return ch;
    }



    public static void main(String[] args) {
        Intervals intervals = new Intervals();
       TreeMap<Integer, Integer> values = new TreeMap<>();

        values.put(5, 10);
        values.put(10, 15);
        values.put(0, 5);
        values.put(20, 25);
        values.put(15, 20);
        values.put(25, 30);
        values.put(26, 29);

        System.out.println("The values sre  "+values.toString());

        System.out.println("The floor of 12 is "+intervals.getFloor(values, 12));
        System.out.println("The ceiling of 14 is "+intervals.getCeiling(values, 14));

        intervals.book(0,5);
        intervals.book(5,10);
        intervals.book(7,20);
        intervals.book(10,20);


//        System.out.println("--------------------");
//        System.out.println(intervals.getChar("Chidozie"));
//        System.out.println("Substring is "+"Chidozie".substring(0,2));

//        Bookings bookings = new Bookings();
//        bookings.setStartPoint(5);
//        bookings.setEndPoint(10);
        intervals.doubleBook(5,20);
        intervals.doubleBook(20,35);
        intervals.doubleBook(10,20);
        intervals.doubleBook(20,30);

        System.out.println(intervals.doubleBookings);
        System.out.println(intervals.normalBookings);


    }
}
