package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MedianAdapterTestSuite {
    @Test
    public void publicationYearMedianTest(){
        //Given
        MedianAdapter medianAdapter = new MedianAdapter();
        Set<Book> booksInLibrary = new HashSet<>();
        booksInLibrary.add(new Book("Rowling","Harry Potter 1",1997,"1234"));
        booksInLibrary.add(new Book("Rowling","Harry Potter 2",2000,"5678"));
        booksInLibrary.add(new Book("Rowling","Harry Potter 3",2002,"9012"));
        booksInLibrary.add(new Book("Rowling","Harry Potter 4",2005,"3456"));
        booksInLibrary.add(new Book("Rowling","Harry Potter 5",2007,"7890"));
        booksInLibrary.add(new Book("Rowling","Harry Potter 6",2010,"5469"));
        booksInLibrary.add(new Book("Rowling","Harry Potter 7",2011,"3447"));
        //When
        double mediana = medianAdapter.publicationYearMedian(booksInLibrary);
        //Then
        assertEquals(2005,mediana);
    }
}
