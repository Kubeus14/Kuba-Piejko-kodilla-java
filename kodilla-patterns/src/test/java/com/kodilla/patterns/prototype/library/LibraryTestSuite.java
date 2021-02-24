package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryTestSuite {
    @Test
    void testGetBook() {
        //Given
        Library library = new Library("Best Library");
        Book book1 = new Book("Harry Potter 1", "Rowling", LocalDate.of(1999, 12, 11));
        Book book2 = new Book("Harry Potter 2", "Rowling", LocalDate.of(2002, 7, 24));
        Book book3 = new Book("Harry Potter 3", "Rowling", LocalDate.of(2005, 3, 17));
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        Library libraryCopy = null;
        try {
            libraryCopy = library.shallowCopy();
            libraryCopy.setName("Best Library 2");
        } catch
        (CloneNotSupportedException e) {
            System.out.println(e);
        } finally {
            System.out.println("Copy finished");
        }
        System.out.println(library);
        System.out.println(libraryCopy);

        Library libraryCopyDeep = null;
        try{
            libraryCopyDeep = library.deepCopy();
            libraryCopyDeep.setName("Best Library 3");
        }
        catch(CloneNotSupportedException e){
            System.out.println(e);
        }
        finally {
            System.out.println("Copy completed");
        }
        //When and Then
        assertEquals(3, library.getBooks().size());
        assertEquals(3,libraryCopy.getBooks().size());
        assertEquals(3,libraryCopyDeep.getBooks().size());

    }
}
