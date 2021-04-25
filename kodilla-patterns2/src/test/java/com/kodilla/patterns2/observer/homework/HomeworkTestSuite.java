package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class HomeworkTestSuite {
    @Test
    public void testUpdate(){
        HomeWorkQueue javaCourse = new JavaCourse();
        HomeWorkQueue htmlCourse = new HtmlCourse();
        MentorForum tomCollins = new MentorForum("Tom Collins");
        MentorForum kateJones = new MentorForum("Kate Jones");
        MentorForum jakeBrown = new MentorForum("Jake Brown");
        javaCourse.checkTask(tomCollins);
        javaCourse.checkTask(kateJones);
        htmlCourse.checkTask(kateJones);
        htmlCourse.checkTask(jakeBrown);
        //When
        javaCourse.addTask("Java Task 1");
        javaCourse.addTask("Java Task 2");
        htmlCourse.addTask("Html task 1");
        htmlCourse.addTask("Html task 2");
        htmlCourse.addTask("Html task 3");
        //Then
        assertEquals(2,tomCollins.getUpdateCount());
        assertEquals(3,jakeBrown.getUpdateCount());
        assertEquals(5,kateJones.getUpdateCount());
    }

}
