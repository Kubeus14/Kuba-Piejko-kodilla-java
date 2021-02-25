package com.kodilla.testing.collection;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public static void beforeAll(){
        oddNumbersExterminator = new OddNumbersExterminator();
    }
    @Test
    void testOddNumbersExterminatorEmptyList(){
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        List<Integer> emptyList = new ArrayList<>();
        //When
        List<Integer> resultList = oddNumbersExterminator.exterminate(emptyList);
        //Then
        assertEquals(emptyList,resultList);
    }
    @Test
    void testOddNumbersExterminatorNormalList(){
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
        //Then
        assertEquals(secondList,resultList);
    }

}