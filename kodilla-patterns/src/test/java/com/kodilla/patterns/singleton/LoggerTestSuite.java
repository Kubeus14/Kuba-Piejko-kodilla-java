package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {


    @Test
    void testLog(){
    //Given
    String user = "user log";
    //When
    Logger.INSTANCE.log("abc");
    Logger.INSTANCE.log(user);
    //Then
    assertEquals(user,Logger.INSTANCE.getLastLog());


    }
}
