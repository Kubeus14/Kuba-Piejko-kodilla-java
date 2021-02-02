package com.kodilla.testing.forum.statistics.statistics;

public class StatisticsForum {

    private int usersQuantity;
    private int postsQuantity;
    private int commentsQuantity;
    private double postsAvgForUser;
    private double commentsAvgForUser;
    private double commentsAvgForPost;

    public int getUsersQty() {
        return usersQuantity;
    }

    public int getPostsQuantity() {
        return postsQuantity;
    }

    public int getCommentsQty() {
        return commentsQuantity;
    }

    public double getPostsAvgForUser() {
        return postsAvgForUser;
    }

    public double getCommentsAvgForUser() {
        return commentsAvgForUser;
    }

    public double getCommentsAvgForPost() {
        return commentsAvgForPost;
    }


    public void calculateAdvStatistics(Statistics statistics) {
        usersQuantity = statistics.usersNames().size();
        postsQuantity = statistics.postsCount();
        commentsQuantity = statistics.commentsCount();
        postsAvgForUser = calculatePostsAvgPerUser();
        commentsAvgForUser = calculateCommentsAvgPerUser();
        commentsAvgForPost = calculateCommentsAvgPerPost();
    }

    private double calculatePostsAvgPerUser() {

        if (usersQuantity > 0) {
            return (double) postsQuantity / usersQuantity;
        } else {
            return 0;
        }
    }

    private double calculateCommentsAvgPerUser() {
        if (usersQuantity > 0) {
            return (double) commentsQuantity / usersQuantity;
        } else {
            return 0;
        }
    }

    private double calculateCommentsAvgPerPost() {
        if (postsQuantity > 0) {
            return (double) commentsQuantity / postsQuantity;
        } else {
            return 0;
        }
    }

    public void showStatistics() {
        System.out.println("Forum advanced statistics:");
        System.out.println("Users quantity: " + usersQuantity);
        System.out.println("Posts quantity: " + postsQuantity);
        System.out.println("Comments quantity: " + commentsQuantity);
        System.out.println("Posts average per user" + postsAvgForUser);
        System.out.println("Comments average per user" + commentsAvgForUser);
        System.out.println("Comments average per post" + commentsAvgForPost);
    }
}
