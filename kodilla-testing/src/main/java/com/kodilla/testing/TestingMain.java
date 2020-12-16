package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.user.Calculator;
import com.kodilla.testing.collection.OddNumbersExterminator;
import java.util.ArrayList;
import java.util.List;

public class TestingMain {
    public static void main(String[] args) {
//1_ex_test_simpleUser
    SimpleUser simpleUser = new SimpleUser("theForumUser");

    String result = simpleUser.getUsername();

    if(result.equals("theForumUser")){
        System.out.println("test Ok");
    }
    else{
        System.out.println("Error");
    }
//2_ex_test_calculator
    Calculator calculator = new Calculator();

    int result1= calculator.add(7,5);
    if(result1==12){
        System.out.println("test add Ok");
    }
    else{
        System.out.println("error add");
    }
    int result2= calculator.substract(7,5);
    if(result2==2){
        System.out.println("test substract ok");
    }
    else{
        System.out.println("error substract");
    }
//3_ex_test_OddNumbersExterminator
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
