package com.collectionframework.doubleendedqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class DoubleEndedQueue {
    public static void main(String[] args) {

        Deque<Integer> dq = new ArrayDeque<>() ;

        dq.offerLast(10) ;
        dq.offerLast(20) ;
        dq.offerLast(30) ;
        dq.offerLast(40) ;

        Iterator<Integer> dqIterator = dq.iterator() ;
        System.out.println("Printing DQueue Value Using Iterator");
        while( dqIterator.hasNext() ){
            int value = dqIterator.next() ;
            System.out.print(value + " ");
        }
        System.out.println();

        System.out.println("Size ==> " + dq.size() );
        System.out.println("first Element ==> " + dq.peekFirst() + " Last Element ==> " + dq.peekLast());
        System.out.println("Removing from First ==> " + dq.pollFirst());
        System.out.println("Removing From Last ==> " + dq.pollLast() );
        System.out.println("Insert From First ==> " + dq.offerFirst(-100));
        System.out.println("Insert From Last ==> " + dq.offerLast(9999));
        System.out.println();
        System.out.println("first Element ==> " + dq.peekFirst() + " Last Element ==> " + dq.peekLast());
    }
}
