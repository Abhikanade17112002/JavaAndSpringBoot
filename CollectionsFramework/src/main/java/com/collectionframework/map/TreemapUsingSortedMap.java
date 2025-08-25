package com.collectionframework.map;

import java.util.SortedMap;
import java.util.TreeMap;

public class TreemapUsingSortedMap {
    public static void main(String[] args) {

        SortedMap<Integer,String> mpp = new TreeMap<>() ;
        mpp.put(10,"A") ;
        mpp.put(40,"D") ;
        mpp.put(30,"C") ;
        mpp.put(20,"B") ;


        System.out.println("By Default Map Is Sorted In Ascending Order Of Keys ");
        mpp.forEach((Integer Key , String value )-> System.out.println("Key ==> " + Key +  " Value ==> " + value));

        System.out.println(" Entries Before 30 ==> " + mpp.headMap(30));
        System.out.println(" Enter from 20 ==> " + mpp.tailMap(20));
        System.out.println("First Entry ==> " + mpp.firstEntry() );
        System.out.println("Last Entry ==> " + mpp.lastEntry());


        SortedMap<Integer,String> mpp2 = new TreeMap<>((Integer A , Integer B )->B-A) ;
        mpp2.put(10,"A") ;
        mpp2.put(40,"D") ;
        mpp2.put(30,"C") ;
        mpp2.put(20,"B") ;
        System.out.println("Map Sorted In Descending Order Of Keys  ");
        mpp2.forEach((Integer Key , String value )-> System.out.println("Key ==> " + Key +  " Value ==> " + value));
    }
}
