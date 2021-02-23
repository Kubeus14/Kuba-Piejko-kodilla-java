package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;

public class LoggerTestSuite {
    private static Logger logger;
    @Test
    void testLog(){

        logger = Logger.INSTANCE;
        logger.log("last user: Tom");


    }
}
