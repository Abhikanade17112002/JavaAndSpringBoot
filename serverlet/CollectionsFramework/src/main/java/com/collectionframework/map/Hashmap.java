package com.collectionframework.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Hashmap {
    public static void main(String[] args) {
        Map< String , Integer > mpp = new HashMap<>() ;

        mpp.put("A" , 1) ;
        mpp.put("B" , 2) ;
        mpp.put("C" , 3) ;
        mpp.put("D" , 4) ;
        mpp.put("E" , 5) ;
//        mpp.put(null,null) ;
        mpp.put("Z",null) ;

        System.out.println("Is Mapp Empty ==> " + mpp.isEmpty() + " " + " Size Of Mapp ==> " + mpp.size());
        System.out.println(" Traversing Mapp ==> " );

        for( Map.Entry<String,Integer> entries : mpp.entrySet() ){
            String key = entries.getKey() ;
            Optional<Integer> value = Optional.ofNullable( entries.getValue() );

            if( value.isPresent()) {
                System.out.println("Key ==> " + key + " " + " Value ==> " + value.get());
            }
            else{
                System.out.println("Key ==> " + key + " " + " Value ==> " + "NULL" );
            }
        }

        System.out.println();
        System.out.println("Traversing Keys ");
        for(String key : mpp.keySet()){
            System.out.println("Key ==> " + key );
        }


        System.out.println();
        System.out.println("Traversing Values ");
        for(Integer value : mpp.values()){
            System.out.println("Value ==> " + value );
        }
        System.out.println("Gettinh value of Key ==> A" + mpp.get("A"));
//        System.out.println("Gettinh value of Key ==> null" + mpp.get(null));

        System.out.println(mpp.getOrDefault("A",10));
    }
}
