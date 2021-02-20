package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTestSuite {

    @Test
    public void testCalculations() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);

        //When
        double addValue = calculator.add(5, 5);
        double subValue = calculator.sub(20, 8);
        double mulValue = calculator.mul(2, 4);
        double divValue = calculator.div(14, 7);

        //Then
        assertEquals(10, addValue);
        assertEquals(12, subValue);
        assertEquals(8, mulValue);
        assertEquals(2, divValue);
    }
}
