package com.stan.springbootcourse.corejava.part3.collections.iterables;


public class Main {
    public static void main(String[] args) {

        GenericList<Users> list = new GenericList<>();
        Users user1 = new Users("John", "Doe", 23);
        Users user2 = new Users("Jane", "Williams", 25);
        Users user3 = new Users("Pete", "Edochie", 27);

        list.addItem(user1);
        list.addItem(user2);
        list.addItem(user3);

        for(var l: list){
            System.out.println("List: "+l);
        }

        //System.out.println(list.getItem(2));

    }
}
