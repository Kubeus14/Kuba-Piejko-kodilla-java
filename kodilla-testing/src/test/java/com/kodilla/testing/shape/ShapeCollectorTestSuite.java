package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShapeCollectorTestSuite {
    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }
    @AfterEach
    public void after(){
        System.out.println("Test Case: end");
    }
    @Nested
    @DisplayName("Test Add and Remove")
    class TestAddAndRemove {
        @DisplayName("When we create figure, then we check that figure was added to list")
        @Test
        public void testAddFigure(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Square(4);
            //When
            shapeCollector.addFigure(shape);
            //Then
            assertEquals(1,shapeCollector.getShapeCollection().size());
        }

        @DisplayName("When we create result, then we check that figure was deleted")
        @Test
        public void testRemoveFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Square(4);
            shapeCollector.addFigure(shape);
            //When
            boolean result = shapeCollector.removeFigure(shape);
            //Then
            assertTrue(result);
            assertEquals(0,shapeCollector.getShapeCollection().size());
        }
    }
    @DisplayName("When we create shapeResultList, then we check that is equal with shapeList")
    @Test
    public void testShowFigures(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shape = new Square(4);
        shapeCollector.addFigure(shape);
        List<Shape> shapeList = new ArrayList<>();
        shapeList.add(shape);
        //When
        List<Shape> shapeResultList = shapeCollector.getShapeCollection();
        //Then
        assertEquals(shapeList.toString(),shapeResultList.toString());
    }
    @DisplayName("When we create shapeResult, then we check that is equal with shape")
    @Test
    public void testGetFigure(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shape = new Square(4);
        shapeCollector.addFigure(shape);
        //When
        Shape shapeResult = shapeCollector.getFigure(0);
        //Then
        assertEquals(shape,shapeResult);
    }
}

