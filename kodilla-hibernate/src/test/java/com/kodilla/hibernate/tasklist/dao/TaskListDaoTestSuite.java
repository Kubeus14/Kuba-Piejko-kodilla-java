package com.kodilla.hibernate.tasklist.dao;


import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.task.dao.TaskDao;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;
    @Autowired
    private TaskDao taskDao;

    private static final String LISTNAME = "List name";
    private static final String DESCRIPTION = "Description to execute";

    @Test
    public void testFindByListName() {
        //Given
        TaskList taskList = new TaskList(LISTNAME, DESCRIPTION);


        //When
        taskListDao.save(taskList);


        //Then
        List<TaskList> readTaskList = taskListDao.findByListName(LISTNAME);


        assertEquals(LISTNAME, readTaskList.get(0).getListName());
        assertEquals(DESCRIPTION, readTaskList.get(0).getDescription());


        //CleanUp
        taskListDao.deleteAll();

    }
    @Test
    void testFindByListNameEmptylist(){
        //Given
        //When
        List<TaskList> readTaskList = taskListDao.findByListName(LISTNAME);
        //Then
        assertEquals(0,readTaskList.size());


    }
    @Test
    void testTaskListDaoSaveWithTasks() {
        //Given
        Task task = new Task("Test: Learn Hibernate", 14);
        Task task2 = new Task("Test: Write some entities", 3);
        TaskFinancialDetails tfd = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        task.setTaskFinancialDetails(tfd);
        task2.setTaskFinancialDetails(tfd2);
        TaskList taskList = new TaskList(LISTNAME, "ToDo tasks");
        taskList.getTasks().add(task);
        taskList.getTasks().add(task2);
        task.setTaskList(taskList);
        task2.setTaskList(taskList);

        //When
        taskListDao.save(taskList);
        int id = taskList.getId();

        //Then
        assertNotEquals(0, id);

        //CleanUp
        //taskListDao.deleteById(id);
    }

}
