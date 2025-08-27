package com.learningmaven;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    
    public App appTest ;
    @BeforeEach
     public void init(){
       appTest = new App() ;
       System.out.println("Initialised");
     }


     @Test
     public void testApp(){
        assertEquals("Hello World!", appTest.main());
     }
     
   
     @AfterEach
     public void teardown(){
        appTest = null ;
        System.out.println("Clean Up");
     }
}
