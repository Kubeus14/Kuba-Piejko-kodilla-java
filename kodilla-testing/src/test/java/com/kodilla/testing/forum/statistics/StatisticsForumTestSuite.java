package com.kodilla.testing.forum.statistics;


import com.kodilla.testing.forum.statistics.statistics.Statistics;
import com.kodilla.testing.forum.statistics.statistics.StatisticsForum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StatisticsForumTestSuite {

    private Statistics statisticsMock;
    private StatisticsForum forumStatistics;


    @BeforeEach
    public void beforeTest() {
        statisticsMock = mock(Statistics.class);
        List<String> listMock = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listMock.add("User");
        }
        when(statisticsMock.usersNames()).thenReturn(listMock);
        when(statisticsMock.postsCount()).thenReturn(20);
        when(statisticsMock.commentsCount()).thenReturn(40);
        forumStatistics = new StatisticsForum();
    }

    @Test
    public void testCalculateAdvStatisticsWithZeroPosts() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(0);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(0, forumStatistics.getPostsQuantity());
        assertEquals(0, forumStatistics.getPostsAvgForUser(), 0.01);
        assertEquals(0, forumStatistics.getCommentsAvgForPost(), 0.01);

    }

    @Test
    public void testCalculateAdvStatisticsWithThousandPosts() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(1000);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(1000, forumStatistics.getPostsQuantity());
        assertEquals(100, forumStatistics.getPostsAvgForUser(), 0.01);
        assertEquals(0.04, forumStatistics.getCommentsAvgForPost(), 0.01);
    }

    @Test
    public void testCalculateAdvStatisticsWithZeroComments() {
        //Given
        when(statisticsMock.commentsCount()).thenReturn(0);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(0, forumStatistics.getCommentsQty());
        assertEquals(0, forumStatistics.getCommentsAvgForUser(), 0.01);
        assertEquals(0, forumStatistics.getCommentsAvgForPost(), 0.01);
    }

    @Test
    public void testCalculateAdvStatisticsLessCommentsThanPosts() {
        //Given
        when(statisticsMock.commentsCount()).thenReturn(2);
        when(statisticsMock.postsCount()).thenReturn(10);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(10, forumStatistics.getPostsQuantity());
        assertEquals(2, forumStatistics.getCommentsQty());
        assertEquals(1, forumStatistics.getPostsAvgForUser(), 0.01);
        assertEquals(0.2, forumStatistics.getCommentsAvgForUser(), 0.01);
        assertEquals(0.2, forumStatistics.getCommentsAvgForPost(), 0.01);
    }

    @Test
    public void testCalculateAdvStatisticsMoreCommentsThanPosts() {
        //Given

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(20, forumStatistics.getPostsQuantity());
        assertEquals(40, forumStatistics.getCommentsQty());
        assertEquals(2, forumStatistics.getPostsAvgForUser(), 0.01);
        assertEquals(4, forumStatistics.getCommentsAvgForUser(), 0.01);
        assertEquals(2, forumStatistics.getCommentsAvgForPost(), 0.01);
    }

    @Test
    public void testCalculateAdvStatisticsWithZeroUsers() {
        //Given
        List<String> listMock = new ArrayList<>();
        when(statisticsMock.usersNames()).thenReturn(listMock);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(0, forumStatistics.getUsersQty());
        assertEquals(0, forumStatistics.getPostsAvgForUser(), 0.01);
        assertEquals(0, forumStatistics.getCommentsAvgForUser(), 0.01);

    }

    @Test
    public void testCalculateAdvStatisticsWithHundredUsers() {
        //Given
        List<String> listMock = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            listMock.add("User");
        }
        when(statisticsMock.usersNames()).thenReturn(listMock);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(100, forumStatistics.getUsersQty());
        assertEquals(0.2, forumStatistics.getPostsAvgForUser(), 0.01);
        assertEquals(0.4, forumStatistics.getCommentsAvgForUser(), 0.01);
    }
}
