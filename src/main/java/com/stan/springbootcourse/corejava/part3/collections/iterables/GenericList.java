package com.stan.springbootcourse.corejava.part3.collections.iterables;

import lombok.Data;

import java.util.Iterator;

@Data
public class GenericList <T> implements Iterable<T> {
    private T[] list = (T[])new Object[10];
    private int count;

    public void addItem(T item) {
        list[count++] = item;
    }

    public T getItem(int index) {
        return list[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator(this);
    }

    public class ListIterator implements Iterator<T> {

        GenericList <T> glist;
        int index;

        public ListIterator(GenericList<T> glist) {
            this.glist = glist;
        }

        @Override
        public boolean hasNext() {
            return index < glist.count;
        }

        @Override
        public T next() {
            return list[index++];
        }
    }
}
