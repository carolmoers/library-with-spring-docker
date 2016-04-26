package br.com.library.models;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class BookTest {

    @Test
    public void createBookTest() {
        int code = 1;
        String title = "Test Title";
        String author = "Test Author";
        String yearPublished = "2011";

        Book book = new Book(code, title, author, yearPublished);

        assertThat(book.getCode(), is(equalTo(code)));
        assertThat(book.getAuthor(), is(equalTo(author)));
        assertThat(book.getTitle(), is(equalTo(title)));
        assertThat(book.getYearPublished(), is(equalTo(yearPublished)));
    }
}