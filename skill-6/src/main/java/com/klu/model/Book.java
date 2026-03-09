package com.klu.model;

public class Book {

    private int bookId;
    private String bookTitle;
    private String authorName;

    public Book() {
    }

    public Book(int bookId, String bookTitle, String authorName) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.authorName = authorName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}