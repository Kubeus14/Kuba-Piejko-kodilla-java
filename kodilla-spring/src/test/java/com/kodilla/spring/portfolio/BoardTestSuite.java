package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class BoardTestSuite {
    @Test
    public void testTaskAdd(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        BoardConfig boardConfig = context.getBean(BoardConfig.class);
        //When
        String task1 = "Task 1";
        String task2 = "Task 2";
        String task3 = "Task 3";
        boardConfig.getToDoList().processOfTasks(task1);
        boardConfig.getToDoList().processOfTasks(task2);
        boardConfig.getToDoList().processOfTasks(task3);
        //Then
        assertEquals(true,boardConfig.getToDoList().processOfTasks(task1));
        assertEquals(true,boardConfig.getInProgressList().processOfTasks(task2));
        assertEquals(true,boardConfig.getDoneList().processOfTasks(task3));




    }


}
