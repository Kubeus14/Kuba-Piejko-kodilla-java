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
        Board board = context.getBean(Board.class);
        //When
        board.getToDoList().addTask("Task 1");
        board.getToDoList().addTask("Task 2");

        board.getInProgressList().addTask("Task 3");
        board.getDoneList().addTask("Task 4");
        board.getDoneList().addTask("Task 5");
        board.getDoneList().addTask("Task 6");
        //Then
        assertEquals(2,board.getToDoList().getTasks().size());
        assertEquals(1,board.getInProgressList().getTasks().size());
        assertEquals(3,board.getDoneList().getTasks().size());




    }


}
