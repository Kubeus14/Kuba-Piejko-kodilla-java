package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTestSuite{
    @Test
    public void testCalculations(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double addValue = calculator.add(3,4);
        double subValue = calculator.sub(5,2);
        double mulValue = calculator.mul(4,4);
        double divValue = calculator.div(8,2);
        //Then
        assertEquals(7,addValue);
        assertEquals(3,subValue);
        assertEquals(16,mulValue);
        assertEquals(4,divValue);
    }
}
