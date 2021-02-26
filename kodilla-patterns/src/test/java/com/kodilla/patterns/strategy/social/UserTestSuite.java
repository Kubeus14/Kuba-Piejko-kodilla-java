package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {
    @Test
    void testDefaultSharingStrategies(){
        //Given
        User user1 =new Millenials("user1");
        //When
        String userSelect1 = user1.choose();
        System.out.println("User1 wants- "+userSelect1);
        //Then
        assertEquals("Choose Facebook",userSelect1);
    }
    @Test
    void testIndividualSharingStrategy(){
        //Give
        User user1 = new Millenials("user1");
        //When
        String user1Select =user1.choose();
        System.out.println("User1 wants- "+user1Select);
        user1.userStrategy(new TwitterPublisher());
        user1Select = user1.choose();
        System.out.println("User1 now wants- "+user1Select);
        //Then
        assertEquals("Choose Twitter",user1Select);
    }
}
