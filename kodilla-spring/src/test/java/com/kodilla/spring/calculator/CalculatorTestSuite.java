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
        double addV = calculator.add(5,5);
        double subV = calculator.sub(5,5);
        double mulV = calculator.mul(5,5);
        double divV = calculator.div(5,5);
        //Then
        assertEquals(10,addV);
        assertEquals(0,subV);
        assertEquals(25,mulV);
        assertEquals(1,divV);

    }
}
