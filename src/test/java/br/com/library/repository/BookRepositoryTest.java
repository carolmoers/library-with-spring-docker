package br.com.library.repository;

import br.com.library.models.Book;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class BookRepositoryTest {

    @Test
    public void createBooksTest() {
        BookRepository booksRepository = new BookRepository();
        booksRepository.createPredefinedBooks();
        List<Book> books= booksRepository.all();

        assertThat(books.size(), is(3));

        assertThat(1, is(equalTo(books.get(0).getCode())));
        assertThat("The Pragmatic Programmer", is(equalTo(books.get(0).getTitle())));
        assertThat("Andrew Hunt, David Thomas", is(equalTo(books.get(0).getAuthor())));
        assertThat("1999", is(equalTo(books.get(0).getYearPublished())));

        assertThat(2, is(equalTo(books.get(1).getCode())));
        assertThat("Head First Java", is(equalTo(books.get(1).getTitle())));
        assertThat("Kathy Sierra, Bert Bates", is(equalTo(books.get(1).getAuthor())));
        assertThat("2005", is(equalTo(books.get(1).getYearPublished())));

        assertThat(3, is(equalTo(books.get(2).getCode())));
        assertThat("Test-driven Development", is(equalTo(books.get(2).getTitle())));
        assertThat("Kent Beck", is(equalTo(books.get(2).getAuthor())));
        assertThat("2003", is(equalTo(books.get(2).getYearPublished())));
    }
}
