package com.collectionframework.iterableandcollection;

import java.util.*;

public class IterableAndCollectionFramework {


    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>() ;

        list.add(1) ;
        list.add(2) ;
        list.add(5) ;
        list.add(19) ;
        System.out.println("Is List Empty ==> " + list.isEmpty() ) ;
        System.out.println("Size Of List ==> " + list.size()) ;

        System.out.println("Before removing ele At Index 2 ==> " + list.contains(5));
        list.remove(2) ;
        System.out.println("After Removing ==> " + list.contains(5));

        System.out.println("Before removing 19 ==> "+ list.contains(19));
        list.remove(Integer.valueOf(19)) ;

        Stack<Integer> stack = new Stack<>() ;
        stack.add(10) ;
        stack.add(40);
        stack.add(50) ;



        list.forEach((Integer num )-> System.out.print( num ));
        System.out.println();



        System.out.println("Before Adding Stack Elements ==> " + list.contains(40));
        list.addAll(stack) ;
        Iterator<Integer> listIterator = list.listIterator();

        while( listIterator.hasNext() ){
            int value = listIterator.next() ;
            System.out.print(value+" " );

            if( value == 2 ){
                listIterator.remove();
            }
        }
        System.out.println();
        for( Integer num : list ){
            System.out.print( num + " ");
        }
        System.out.println();

        System.out.println("After Adding Stack Elements ==> " + list.contains(40));

        System.out.println("Contains all elemets of stack ==> " + list.containsAll(stack));
        list.removeAll(stack);
        System.out.println("After Removing All The elements of stack ==> " + list.removeAll(stack));



   try {
       System.out.println("Max Element ==> " + Collections.max(list));
       System.out.println("Min Element ==> " + Collections.min(list));
       System.out.println("After Sorting ==> ");
       Collections.sort(list);
       list.forEach((Integer num) -> System.out.print(num));
       System.out.println();


   } catch (Exception e) {
       System.out.println(e.getMessage());
   }
        System.out.println("clearing the list ==> " );
        list.clear();

        System.out.println("Size ==> " + list.size() + " " + list.isEmpty());

    }


}
