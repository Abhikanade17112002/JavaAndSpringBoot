package com.collectionframework.set;

import java.util.HashSet;
import java.util.Set;

public class Seet {
    public static void main(String[] args) {
        Set<Integer> st1 = new HashSet<>() ;
        st1.add(10) ;
        st1.add(10) ;
        st1.add(20) ;
        st1.add(15) ;
        st1.add(11) ;
        st1.add(14) ;
        st1.add(null) ;

        System.out.println("Printing Set Values ==> ");
        st1.forEach((Integer num) -> System.out.println(num));
        Set<Integer> st2 = new HashSet<>() ;
        st2.add(10) ;
        st2.add(10) ;
        st2.add(3) ;
        st2.add(5) ;
        st2.add(11) ;
        st2.add(14) ;
        st2.add(null) ;
        System.out.println("Printing Set Values ==> ");
        st2.forEach((Integer num) -> System.out.println(num));

        System.out.println("After Union ==> ");
        st1.addAll(st2) ;
        st1.forEach((Integer num) -> System.out.println(num));
        System.out.println("After Intersection ==> ");
        st1.retainAll(st2) ;
        st1.forEach((Integer num) -> System.out.println(num));
        System.out.println("After Difference ==> ");
        st1.removeAll(st2) ;
        st1.forEach((Integer num) -> System.out.println(num));



    }
}
