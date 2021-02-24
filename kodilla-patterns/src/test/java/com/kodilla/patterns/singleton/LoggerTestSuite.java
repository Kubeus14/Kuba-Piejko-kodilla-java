package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {
    private static Logger logger;

    @Test
    void testLog(){
    //Given
    String user = "user log";
    //When
    Logger.instanceReturn().log(user);
    //Then
    assertEquals(user,Logger.instanceReturn().getLastLog());


    }
}
