package com.kodilla.patterns.factory;

import com.kodilla.patterns.factory.tasks.Task;
import com.kodilla.patterns.factory.tasks.TaskFactory;
import org.junit.jupiter.api.Test;

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
    void testDrivingTask(){
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task drTask = taskFactory.processTask(TaskFactory.DrivingAsg);
        //Then

    }


}
