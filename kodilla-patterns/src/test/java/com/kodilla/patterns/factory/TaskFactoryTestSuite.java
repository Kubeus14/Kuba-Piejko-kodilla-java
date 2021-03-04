package com.kodilla.patterns.factory;

import com.kodilla.patterns.factory.tasks.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskFactoryTestSuite {
    @Test
    void testShoppingTask(){
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task shTask = taskFactory.processTask(TaskFactory.ShoppingAsg);
        //Then

        assertEquals( taskFactory.processTask(TaskFactory.ShoppingAsg));

    }

    private void assertEquals(Task processTask) {
    }

    @Test
    void testPaintingTask(){
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task ptTask = taskFactory.processTask(TaskFactory.PaintingAsg);
        //Then

    }
    @Test
    void testProcessTask(){
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When and them
        assertAll(
                ()->assertTrue(taskFactory.processTask(TaskFactory.ShoppingAsg) instanceof ShoppingTask),
                ()->assertTrue(taskFactory.processTask(TaskFactory.PaintingAsg) instanceof PaintingTask),
                ()->assertTrue(taskFactory.processTask(TaskFactory.DrivingAsg) instanceof DrivingTask)
        );

    }


}
