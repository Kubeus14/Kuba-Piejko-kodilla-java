package com.kodilla.stream.book;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookTestSuite{
    @Test
    void testGetListUsingFor() {
        //Given
        BookDirectory bookDirectory = new BookDirectory();
        //When
        List<Book> books = bookDirectory.getList();
        //Then
        int nbOfBooksAfter2007 = 0;
        for(Book book : books){
            if(book.getYearOfPubblication()>2007){
                nbOfBooksAfter2007++;
            }
        }
        assertEquals(3,nbOfBooksAfter2007);
    }
    @Test
    void testGetListUsingIntStream() {
        //Given
        BookDirectory bookDirectory = new BookDirectory();
        //When
        List<Book> books = bookDirectory.getList();
        //Then
        int nmbOfBooksAfter2007 = IntStream.range(0,books.size())
                .filter(n->books.get(n).getYearOfPubblication()>2007)
                .map(n->1)
                .sum();
        assertEquals(3,nmbOfBooksAfter2007);

    }
    @Test
    void testGetListUsingIntStream2() {
        //Given
        BookDirectory bookDirectory = new BookDirectory();
        //When
        List<Book> books = bookDirectory.getList();
        //Then
        long numberOfBooksAfter2007 = IntStream.range(0,books.size())
                .filter(n->books.get(n).getYearOfPubblication()>2007)
                .count();
        assertEquals(3,numberOfBooksAfter2007);
    }

}

