package com.kodilla.testing.collection;


import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class CollectionTestSuite{
    private static OddNumbersExterminator oddNumbersExterminator;
    @BeforeEach
    public void before(){
        System.out.println("Test case: begin");
    }
    @AfterEach
    public void after(){
        System.out.println("Test case: after");
    }
    @BeforeAll
    public static void beforeClass(){
        oddNumbersExterminator = new OddNumbersExterminator();
    }
    @DisplayName("when create emptyList and resultList, we check if they are equal")
    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        List<Integer> emptyList = new ArrayList<>();
        //When
        List<Integer> resultList = oddNumbersExterminator.exterminate(emptyList);
        System.out.println("Testing empty list");
        //When
        Assertions.assertEquals(emptyList,resultList);
    }
    @DisplayName("when we create resultList, then we check if it equals secondList")
    @Test
    public void testOddNumbersExterminationNormalList(){
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        List<Integer> normalList = new ArrayList<>();
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
        Assertions.assertEquals(secondList,resultList);
    }
}