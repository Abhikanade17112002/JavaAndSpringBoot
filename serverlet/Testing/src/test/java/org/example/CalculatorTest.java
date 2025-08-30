package org.example;


import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    public Calculator calculator  ;
    public SortingArray  sortingArray;


    @BeforeEach
    public void init(){
        calculator = new Calculator() ;
        sortingArray = new SortingArray() ;
        System.out.println("Initialising calculator and sorting array");
    }
    @AfterEach
    public void teardown(){
        calculator = null ;
        sortingArray = null ;
        System.out.println("Initialising calculator and sorting array to NULL ");
    }

    @Test
    public void testAddition(){
        assertEquals( 0, calculator.addition(2 , 3 ),()->"What The Fuck" ) ;
    }

    @Test
    public void testSubstraction(){
        assertEquals( -1, calculator.substraction(2 , 3 ) ) ;
    }

    @Test
    public void tesDivision(){
        assertEquals( 2, calculator.division(6 , 3 ) ) ;
    }

    @Test
    public void testMultiplication(){
        assertEquals( 6, calculator.multiplication(2 , 3 ) ) ;
    }

    @Test
    public void testSortArray(){
        List expectedList = Arrays.asList(1,2,3,4,5) ;
        List actualList = Arrays.asList(2,3,4,1,5) ;
        Collections.sort(actualList);
        assertArrayEquals(expectedList.toArray(),actualList.toArray(),()->"Failure");
    }

    @Test
    public void testNullPointerException(){
        try {

            int arr[] = null ;
            assertThrows(NullPointerException.class , ()->sortingArray.sortArray(arr)) ;

        }
        catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testTimedAraySort(){
        int arr [] = { 1 , 2,3 } ;
        try{

              assertTimeout(Duration.ofMillis(10) , ()->sortingArray.sortArrayTimed(arr));


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
