package br.com.library.models;

public class Book {
    private Integer code;
    private String title;
    private String author;
    private String yearPublished;

    public Book(Integer code, String title, String author, String yearPublished) {
        this.code = code;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public int getCode() {
        return this.code;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getTitle() {
        return this.title;
    }

    public String getYearPublished() {
        return this.yearPublished;
    }
}
