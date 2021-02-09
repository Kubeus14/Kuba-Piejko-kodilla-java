package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Forum{
    private final List<ForumUser> forumUserList = new ArrayList<>();
    public Forum(){
        forumUserList.add(new ForumUser(1,"Tom",'M', LocalDate.of(1993, Month.MAY,14),8));
        forumUserList.add(new ForumUser(2, "Johny", 'M', LocalDate.of(1986, Month.JUNE, 3), 1));
        forumUserList.add(new ForumUser(3, "Max", 'M', LocalDate.of(1967, Month.JULY, 29), 3));
        forumUserList.add(new ForumUser(4, "Kate", 'F', LocalDate.of(1989, Month.NOVEMBER, 15), 7));
        forumUserList.add(new ForumUser(5, "Caroline", 'F', LocalDate.of(1984, Month.APRIL, 6), 0));
        forumUserList.add(new ForumUser(6, "Roy", 'M', LocalDate.of(2000, Month.SEPTEMBER, 27), 6));
        forumUserList.add(new ForumUser(7, "Elizabeth", 'F', LocalDate.of(1993, Month.DECEMBER, 11), 5));
        forumUserList.add(new ForumUser(8, "Martin", 'M', LocalDate.of(2001, Month.MARCH, 3), 10));
        forumUserList.add(new ForumUser(9, "Amy", 'F', LocalDate.of(1999, Month.JUNE, 18), 7));
        forumUserList.add(new ForumUser(10, "Bernadette", 'F', LocalDate.of(1985, Month.AUGUST, 22), 2));
    }
    public List<ForumUser> getForumUserList(){
        return new ArrayList<>(forumUserList);
    }
}
