package com.kodilla.patterns.prototype.library;

import com.kodilla.patterns.prototype.Prototype;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class Library extends Prototype<Library> {

    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
    public void addBook(Book book){
         books.add(book);
    }


    @Override
    public String toString(){
        String b = "Library: "+name+" \n";
        for(Book book : books){
            b = b + book.toString()+"\n";
        }
        return b;
    }
    public Library shallowCopy() throws CloneNotSupportedException{
        return super.clone();
    }
    public Library deepCopy() throws CloneNotSupportedException{
        Library libraryCopy =  super.clone();
        libraryCopy.setBooks(new HashSet<>());

        return libraryCopy;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(name, library.name) &&
                Objects.equals(books, library.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,books);
    }
}
