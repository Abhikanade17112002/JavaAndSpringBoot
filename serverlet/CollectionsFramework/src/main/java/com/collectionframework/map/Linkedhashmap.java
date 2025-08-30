package com.collectionframework.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Linkedhashmap {
    public static void main(String[] args) {

//         Hash Map Can Maintain Insertion and Access Order Also

        Map<Integer,String> mpp = new LinkedHashMap<>() ;
        mpp.put(10,"A") ;
        mpp.put(20,"B") ;
        mpp.put(30,"C") ;
        mpp.put(40,"D") ;
        System.out.println("Printing Linked Hash Map ==> ");
        mpp.forEach((Integer Key , String value )-> System.out.println("Key ==> " + Key +  " Value ==> " + Key));

        Map<Integer,String> mpp2 = new HashMap<>() ;
        mpp2.put(10,"A") ;
        mpp2.put(20,"B") ;
        mpp2.put(30,"C") ;
        mpp2.put(40,"D") ;
        System.out.println("Printing  Hash Map ==> ");
        mpp2.forEach((Integer Key , String value )-> System.out.println("Key ==> " + Key +  " Value ==> " + Key));



        Map<Integer,String> mpp3 = new LinkedHashMap<>(16,0.75f , true) ;
        mpp3.put(10,"A") ;
        mpp3.put(20,"B") ;
        mpp3.put(30,"C") ;
        mpp3.put(40,"D") ;
        mpp3.get(10) ;
        mpp3.get(30) ;
        System.out.println("Printing Linked Hash Map After Turning On Access Order  ==> ");
        mpp3.forEach((Integer Key , String value )-> System.out.println("Key ==> " + Key +  " Value ==> " + Key));

    }
}
