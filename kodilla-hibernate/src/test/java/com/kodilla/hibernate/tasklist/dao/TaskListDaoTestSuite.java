package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.dao.TaskDao;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


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

}
