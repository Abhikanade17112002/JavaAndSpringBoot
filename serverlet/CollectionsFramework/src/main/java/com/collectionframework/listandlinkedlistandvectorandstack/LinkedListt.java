package com.collectionframework.listandlinkedlistandvectorandstack;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListt {
    public static void main(String[] args) {
        List<Integer> ll = new LinkedList<>() ;
        ll.addFirst(10);
        ll.add(20);
        ll.add(30);
        ll.add(40);
        ll.add(2,25) ;
        ll.addLast(100);
        System.out.println("Size ==> " + ll.size());
        System.out.println("First ==> " + ll.getFirst());
        System.out.println("Last ==> " + ll.getLast());

        Iterator<Integer> iterator = ll.iterator() ;
        while( iterator.hasNext() ){
            int value = iterator.next() ;
            System.out.print(value + " ");
        }
    }
}
