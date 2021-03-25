package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser{
    private final int IdNumber;
    private final String userName;
    private final char sex;
    private LocalDate birthDate;
    private int postsQty;

    public ForumUser(int idNumber, String userName, char sex, LocalDate birthDate, int postsQty) {
        IdNumber = idNumber;
        this.userName = userName;
        this.sex = sex;
        this.birthDate = birthDate;
        this.postsQty = postsQty;
    }

    public int getIdNumber() {
        return IdNumber;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPostsQty() {
        return postsQty;
    }
    @Override
    public String toString() {
        return "ForumUser{" +
                "IDNumber=" + IdNumber +
                ", name='" + userName + '\'' +
                ", sex=" + sex +
                ", birthdayDate=" + birthDate +
                ", postsQty=" + postsQty +
                '}';
    }
}