package com.collectionframework.priorityqueueandcomparatorvscomparable;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample {
    public static void main(String[] args) {

        Queue<Integer> pq = new PriorityQueue<>() ; // Min Heap By Default

        pq.offer(7) ;
        pq.offer(2) ;
        pq.offer(4) ;
        pq.offer(3) ;

        System.out.println("Printing using Foreach ==> ");

        pq.forEach(( Integer num )-> System.out.print(num+ " "));
        System.out.println();

        System.out.println("Printing Using while Loop ");

        while( ! pq.isEmpty() ){

            int top = pq.poll() ;
            System.out.print(top + " ");
        }

        System.out.println("Max Heap ==> ");

        Queue<Integer> mpq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1 ;
            }
        }) ; // Max Heap By
        mpq.offer(7) ;
        mpq.offer(2) ;
        mpq.offer(4) ;
        mpq.offer(3) ;

        System.out.println("Printing using Foreach ==> ");

        mpq.forEach(( Integer num )-> System.out.print(num+ " "));
        System.out.println();

        System.out.println("Printing Using while Loop ");

        while( ! mpq.isEmpty() ){

            int top = mpq.poll() ;
            System.out.print(top + " ");
        }


    }
}
