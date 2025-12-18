package com.stan.springbootcourse.corejava.part3;

import lombok.NoArgsConstructor;

import java.util.Iterator;

@NoArgsConstructor
public class GenericList<T> implements Iterable<T> {
    private T[] list = (T[]) new Object[10];
    public int index;

    private void add(T item) {
        list[index++] = item;
    }

    public T get(int index) {
        return list[index];
    }

    private void printList() {
        for (T value : list) {
            System.out.println(value);
        }
    }

    public static void main(String[] args) {
        GenericList<String> list = new GenericList<String>();
        list.add("1");
        list.add("2");
        list.add("3");

        list.printList();

        GenericList<User> user = new GenericList<>();
        user.add(new User("1", "John", "Doe"));
        user.add(new User("2", "Jane", "Doe"));
        user.add(new User("3", "Jack", "Doe"));

        user.printList();
        System.out.println(";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;");
        var listIteravle = user.iterator();
        while (listIteravle.hasNext()) {
            var currentItem = listIteravle.next();
            System.out.println(currentItem);
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new ListIterator(this);
    }

    private class ListIterator implements Iterator<T> {
        GenericList<T> list ;
        int index;
        ListIterator(GenericList<T> list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return index < list.index;
        }

        @Override
        public T next() {
            return list.list[index++];
        }
    }
}
