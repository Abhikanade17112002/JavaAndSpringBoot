package com.collectionframework.listandlinkedlistandvectorandstack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Listt {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>() ;
        list.add(10) ;
        list.add(20) ;
        list.add(30) ;
        list.add(2,25);
        list.add(3,26);
        list.add(4,27);

        System.out.println("Initial Size ==> " + list.size());

        list.forEach(( Integer num ) -> System.out.print(num + " "));
        System.out.println();
        System.out.println("Setting Element At Index 3 = 3333 " + list.set(3,333));
        System.out.println("Getting Updated Element At Index 3 == > " + list.get(3) );
        System.out.println("Removing Element At Index 3 ==> " + list.remove(3));
        System.out.println("Removing Element 20 ==> " + list.remove(Integer.valueOf(20)) );
        System.out.println("Checking List Contains 20 ==> " + list.contains(Integer.valueOf(20)));
        System.out.println("Checking Index , FirstIndex , And LastIndex Of 25 ==> " + list.indexOf(25) + " " + list.lastIndexOf(25));

        List<Integer> demoList = Arrays.asList(30 , 35 , 40 , 45 ) ;
        System.out.println("Adding demoList inti list ");
        list.addAll(demoList) ;
        ListIterator<Integer> iterator = list.listIterator();
        System.out.println("After adding the demolist ==> ");
        while( iterator.hasNext() ){
            int value = iterator.next() ;
            int nextIndex = iterator.nextIndex();
            int prevIndex = iterator.previousIndex() ;
            System.out.println("Element ==> " + value + " nextIndex ==> " + nextIndex + " prevIndex ==> "+ prevIndex);
            if( value == 30 ){
                iterator.add(97);
            }
        }


        System.out.println("Traversing In Backward ==> ");
        ListIterator<Integer> backIterator = list.listIterator(list.size()) ;

        while( backIterator.hasPrevious() ){
            int value = backIterator.previous();
            int prevIndex = backIterator.nextIndex() ;
            int nextIndex = backIterator.previousIndex();
            System.out.println("Element ==> " + value + " nextIndex ==> " + nextIndex + " prevIndex ==> "+ prevIndex);
        }


        System.out.println("Sorting list in descending order ==> ");
        list.sort((Integer a , Integer b )->b-a);
        iterator = list.listIterator();
        while( iterator.hasNext() ){
            int value = iterator.next() ;

            System.out.println("Element ==> " + value );

        }
    }
}
