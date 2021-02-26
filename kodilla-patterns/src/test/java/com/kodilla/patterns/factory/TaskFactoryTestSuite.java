package com.kodilla.patterns.factory;

import com.kodilla.patterns.factory.tasks.TaskFactory;
import com.kodilla.patterns.factory.tasks.Tasks;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskFactoryTestSuite {
    @Test
    void testShoppingTask(){
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Tasks shTask = taskFactory.processTask(TaskFactory.ShoppingAsg);
        //Then
        assertEquals("Shopping",shTask.getTaskName() );
        assertEquals(true,shTask.isTaskExecuted());

    }
    @Test
    void testPaintingTask(){
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Tasks ptTask = taskFactory.processTask(TaskFactory.PaintingAsg);
        //Then
        assertEquals("Painting",ptTask.getTaskName());
        assertEquals(false,ptTask.isTaskExecuted());
    }
    @Test
    void testDrivingTask(){
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Tasks drTask = taskFactory.processTask(TaskFactory.DrivingAsg);
        //Then
        assertEquals("Driving",drTask.getTaskName());
        assertEquals(true,drTask.isTaskExecuted());
    }

}
