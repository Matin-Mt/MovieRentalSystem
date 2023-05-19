package org.example;

import java.time.LocalDate;

public class Book extends Item {
    private String writer;
    private String publisher;
    private String bookCover;

    public Book(long id, String title, String genre, LocalDate releaseDate, boolean isAvailable,
                String writer, String publisher, String bookCover) {
        super(id, title, genre, releaseDate, isAvailable);
        this.writer = writer;
        this.publisher = publisher;
        this.bookCover = bookCover;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getBookCover() {
        return bookCover;
    }

    public void setBookCover(String bookCover) {
        this.bookCover = bookCover;
    }
}
