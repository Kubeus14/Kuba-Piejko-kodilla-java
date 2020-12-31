package com.kodilla.stream.world.tasks;

import com.kodilla.stream.tasks.Board;
import com.kodilla.stream.tasks.Task;
import com.kodilla.stream.tasks.TaskList;
import com.kodilla.stream.tasks.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class testAddTaskListAverageWorkingOnTask {

    public Board prepareTestData() {
        //users
        User user1 = new User("deweloper1", "Jan Nowak");
        User user2 = new User("manager", "Maria Kot");
        User user3 = new User("deweloper2", "Karolina Kozłowska");
        User user4 = new User("deweloper3", "Tomasz Musiał");
        //tasks
        Task task1 = new Task("Prepare an Audit Task",
                "Think and write a preliminary plan\n" +
                        "audits task for this year",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(30));
        Task task2 = new Task("IT Audit",
                "Make Audit task in IT sector",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().minusDays(5));
        Task task3 = new Task("Accounting audit",
                "Make an audit in the accounting department",
                user3,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(15));
        Task task4 = new Task("Financial Audit",
                "Make an audit in the finance department",
                user3,
                user2,
                LocalDate.now().minusDays(10),
                LocalDate.now().plusDays(25));
        Task task5 = new Task("HR Audit",
                "Make an audit in the HR department",
                user4,
                user2,
                LocalDate.now(),
                LocalDate.now().plusDays(5));
        Task task6 = new Task("Report on the audit task",
                "Make a report on the audit task",
                user4,
                user2,
                LocalDate.now().minusDays(15),
                LocalDate.now().minusDays(2));
        //taskLists
        TaskList taskListToDo = new TaskList("Things to do");
        taskListToDo.addTask(task1);
        taskListToDo.addTask(task3);
        TaskList taskListInProgress = new TaskList("Processing");
        taskListInProgress.addTask(task5);
        taskListInProgress.addTask(task4);
        taskListInProgress.addTask(task2);
        TaskList taskListDone = new TaskList("Finished");
        taskListDone.addTask(task6);
        //board
        Board project = new Board("Project Audit Task");
        project.addTaskList(taskListToDo);
        project.addTaskList(taskListInProgress);
        project.addTaskList(taskListDone);
        return project;
    }

    @Test
    public void testAddTaskList() {
        //Given
        Board project = prepareTestData();
        //When

        //Then
        Assertions.assertEquals(3, project.getTaskLists().size());
    }

    @Test
    public void testAddTaskListFindUsersTasks() {
        //Given
        Board project = prepareTestData();
        //When
        User user = new User("developer1", "Jan Nowak");
        List<Task> tasks = project.getTaskLists().stream()
                .flatMap(l -> l.getTasks().stream())
                .filter(t -> t.getAssignedUser().equals(user))
                .collect(toList());
        //Then
        Assertions.assertEquals(2, tasks.size());
        Assertions.assertEquals(user, tasks.get(0).getAssignedUser());
        Assertions.assertEquals(user, tasks.get(1).getAssignedUser());
    }

    @Test
    public void testAddTaskListFindOutdatedTasks() {
        //Given
        Board project = prepareTestData();

        //When
        List<TaskList> undoneTasks = new ArrayList<>();
        undoneTasks.add(new TaskList("Things to do"));
        undoneTasks.add(new TaskList("Processing"));
        List<Task> tasks = project.getTaskLists().stream()
                .filter(undoneTasks::contains)
                .flatMap(tl -> tl.getTasks().stream())
                .filter(t -> t.getDeadline().isBefore(LocalDate.now()))
                .collect(toList());

        //Then
        Assertions.assertEquals(1, tasks.size());
        Assertions.assertEquals("IT Audit", tasks.get(0).getTitle());
    }

    @Test
    public void testAddTaskListFindLongTasks() {
        //Given
        Board project = prepareTestData();

        //When
        List<TaskList> inProgressTasks = new ArrayList<>();
        inProgressTasks.add(new TaskList("Processing"));
        long longTasks = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap(tl -> tl.getTasks().stream())
                .map(t -> t.getCreated())
                .filter(d -> d.compareTo(LocalDate.now().minusDays(10)) <= 0)
                .count();

        //Then
        Assertions.assertEquals(2, longTasks);
    }

    @Test
    public void testAddTaskListAverageWorkingOnTask(){
        //Given
        Board project = prepareTestData();
        //When
        List<TaskList> inProgressTasks = new ArrayList<>();
        inProgressTasks.add(new TaskList("Processing"));

        int sumOfDays = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap(tl -> tl.getTasks().stream())
                .map(task -> Period.between(task.getCreated(), LocalDate.now()).getDays())
                .reduce(0, (sum, current)->sum+=current );

        int tasksQty = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap(tl -> tl.getTasks().stream())
                .map(task -> Period.between(task.getCreated(), LocalDate.now()).getDays())
                .map(t ->1)
                .reduce(0, (sum, current)->sum+=current );

        double average = sumOfDays/tasksQty;

        double avg = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap(tl -> tl.getTasks().stream())
                .map(task -> Period.between(task.getCreated(), LocalDate.now()).getDays())
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();

        //Then
        Assertions.assertEquals(10.0, average, 0.0001);
        Assertions.assertEquals(10.0, avg, 0.0001);
    }
}
