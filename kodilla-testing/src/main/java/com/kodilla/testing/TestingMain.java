package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.user.Calculator;
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
//3_ex_test_
    }
}