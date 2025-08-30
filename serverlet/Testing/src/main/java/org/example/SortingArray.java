package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SortingArray {

    public int[] sortArray( int [] array ){
        Arrays.sort(array);
        return array ;
    }
    public int[] sortArrayTimed( int [] array ) throws InterruptedException {
        Thread.sleep(5);
        Arrays.sort(array);
        return array ;
    }
}
