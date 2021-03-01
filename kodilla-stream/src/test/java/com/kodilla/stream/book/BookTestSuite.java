package com.kodilla.stream.book;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTestSuite {
    @Test
    void testGetListUsingFor() {
        //Given
        BookDirectory bookDirectory = new BookDirectory();
        //When
        List<Book> books = bookDirectory.getList();
        //Then
        int numberBookAfter2007 = IntStream.range(0,books.size())
                .filter(n->books.get(n).getYearOfPublication()>2007)
                .map(n->1)
                .sum();
        assertEquals(3,numberBookAfter2007);



    }
    @Test
    void testGetListUsingIntStream() {

    }
    @Test
    void testGetListUsingIntStream2() {
        //Given
        BookDirectory bookDirectory = new BookDirectory();
        //When
        List<Book> books = bookDirectory.getList();
        //Then
        int numberBookAfter2007 = (int) IntStream.range(0,books.size())
                .filter(n->books.get(n).getYearOfPublication()>2007)
                .count();
        assertEquals(3,numberBookAfter2007);
    }

}

