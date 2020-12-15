//zadanie
package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {
    public List<Integer> exterminate(List<Integer> numbers){
        List<Integer>oddNumbersList = new ArrayList<>();

        for(int number : numbers){
            if(number%2==0){
                oddNumbersList.add(number);
            }
        }
        return oddNumbersList;
    }
}



// test do zadania
package com.kodilla.testing.collection;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;
import com.kodilla.testing.calculator.Calculator;

public class CollectionTestSuite {
    private static OddNumbersExterminator oddNumbersExterminator;
    @Before
    public void before() {
        System.out.println("Test Case: begin");
    }
    @After
    public void after(){
        System.out.println("Test Case: end");
    }

    @BeforeClass
    public static void beforeClass(){
        oddNumbersExterminator = new OddNumbersExterminator();
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();

        List<Integer> emptyList = new ArrayList<>();
        //When
        List<Integer> resultList = oddNumbersExterminator.exterminate(emptyList);

        System.out.println("Testing empty list");
        //Then
        Assert.assertEquals(emptyList, resultList);
    }


    @Test
    public void testOddNumbersExterminatorNormalList () {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> normalList = new ArrayList<>();
        normalList.add(22);
        normalList.add(4);
        normalList.add(13);
        normalList.add(14);
        normalList.add(57);
        normalList.add(46);

        List<Integer> secondList = new ArrayList<>();
        secondList.add(22);
        secondList.add(4);
        secondList.add(14);
        secondList.add(46);
        //When
        List<Integer> resultList = oddNumbersExterminator.exterminate(normalList);
        System.out.println("Testing normal list");

        //Then
        Assert.assertEquals(secondList, resultList);
    }
}
