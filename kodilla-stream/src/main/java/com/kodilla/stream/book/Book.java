package com.kodilla.stream.book;

public final class Book{
    private final String author;
    private final String title;
    private final int yearOfPubblication;
    private final String signature;

    public Book(String author, String title, int yearOfPubblication, String signature) {
        this.author = author;
        this.title = title;
        this.yearOfPubblication = yearOfPubblication;
        this.signature = signature;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfPubblication() {
        return yearOfPubblication;
    }

    public String getSignature() {
        return signature;
    }
    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", yearOfPublication=" + yearOfPubblication +
                ", signature='" + signature + '\'' +
                '}';
    }
}
