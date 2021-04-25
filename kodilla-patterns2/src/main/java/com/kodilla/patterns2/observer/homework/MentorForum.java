package com.kodilla.patterns2.observer.homework;

public class MentorForum implements Observer{
    private final String mentorName;
    private int updateCount;

    public MentorForum(String mentorName) {
        this.mentorName = mentorName;
    }
    @Override
    public void update(HomeWorkQueue homeWorkQueue){
        System.out.println(mentorName+" new student put task into"+homeWorkQueue.getStudentName()+ "\n" +
                "and task to check"+homeWorkQueue.getTasks().size());
        updateCount++;
    }

    public String getMentorName() {
        return mentorName;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
