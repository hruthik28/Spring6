package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.Arrays;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalculateAreaTest {

    CalculateArea ca = new CalculateArea();

    @Test
    public void test(){
        assertEquals(9, ca.areaOfSq(3));
        System.out.println("test 1");

    }


    //using supplier functional interface
    @Test
    public void test_Not_Supplier(){
        assertEquals(9, ca.areaOfSq(3), "Area is wrong");
        System.out.println("test 2");

    }

    @Test
    public void test_Supplier(){
        //assertEquals(6, ca.areaOfSq(3), ()->"Area is wrong");
        System.out.println("test 3");
    }

    //assertArrayEquals()
    @Test
    void testArray(){

        int[] expected = {2,3,4,5};
        int []actual = {3,2,4,5};

        Arrays.sort(actual); // if both arrays are not in same order, then assertion fails
        assertArrayEquals(expected, actual);
        System.out.println("test 4");
    }

    // if exception is thrown then should pass test case, and should fail test case if no exception
   @Test
    void arrayException(){

        try{
            //int unsorted[] = {2,1,4};
            int unsorted[] = null;
            int sorted[] = ca.sortingArray(unsorted);
            for(int element: sorted){
                System.out.print(element);
            }
            System.out.println("Statements above exception");
            fail(); // explicitely failing the test case if no exception
        }catch (NullPointerException e){
            System.out.println("Exception generated");
            System.out.println("test 5");
        }
    }

    @Test
    void arrException(){
        //int unsorted[] = {2,1,4};
        int unsorted[] = null;
        assertThrows(NullPointerException.class, ()-> ca.sortingArray(unsorted));
        // if sortingArray throws nullPointer exception then test case passes else it fails
        System.out.println("test 6");
    }

    @Test
    void  arrTimeout_Performance(){
        int unsorted[] = {2,1,4};
        assertTimeout(Duration.ofMillis(10), ()-> ca.sortArryTimeout(unsorted));
        // if the sortArryTimeout90 method is executed under 10 miliseconds then test case passes, else it fails
        System.out.println("test 7");
    }

    @BeforeEach
    void init(){
        System.out.println("Before each test");
    }

    @AfterEach
    void destory(){
        System.out.println("After each test");
    }

    @BeforeAll
    static void beforeAll(){
        //static - will be called before constructor execution,
        //it is independent of the instance, not dependent on object,
        //without the object, with class name itself it can be invoked
        System.out.println("Before all test");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("After all test");
    }

    CalculateAreaTest(){
        System.out.println("Test obj is created before test method and this is a constructor");
    }
}
