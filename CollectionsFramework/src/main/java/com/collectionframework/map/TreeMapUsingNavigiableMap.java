package com.collectionframework.map;

import java.util.NavigableMap;
import java.util.TreeMap;

public class TreeMapUsingNavigiableMap {
    public static void main(String[] args) {


        NavigableMap<Integer,String> mpp = new TreeMap<>() ;
        // Adding 10 dummy values

        mpp.put(103, "Cherry");
        mpp.put(104, "Date");
        mpp.put(106, "Fig");
        mpp.put(107, "Grapes");
        mpp.put(110, "Lemon");
        mpp.put(101, "Apple");
        mpp.put(102, "Banana");
        mpp.put(108, "Honeydew");
        mpp.put(109, "Kiwi");
        mpp.put(105, "Elderberry");


        // Printing the map
        System.out.println("NavigableMap values: " + mpp);

        System.out.println("Lower Entry To 102 ==> " + mpp.lowerEntry(102));
        System.out.println("Foor Entry To 102 ==> " + mpp.floorEntry(102));
        System.out.println("Ceil Entry To 102 ==> " + mpp.ceilingEntry(102));
        System.out.println("Ceil Key To 102 ==> " + mpp.ceilingKey(102));
        System.out.println("Floor Key To 102 ==> " + mpp.floorKey(102));
        System.out.println("Ceil Entry To 102 ==> " + mpp.ceilingEntry(102));
        System.out.println("First Entry ==> " + mpp.firstEntry());
        System.out.println("Last Entry ==> " + mpp.lastEntry());
        System.out.println("Pool First ==>> " + mpp.pollFirstEntry());
        System.out.println("Poll Last ==> " + mpp.pollLastEntry());

    }
}
