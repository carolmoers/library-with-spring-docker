package br.com.library.controllers;

import br.com.library.models.Book;
import br.com.library.repository.BookRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class BooksControllerTest {

    @Mock
    BookRepository bookRepository;

    BooksController controller;

    @Before
    public void setUp() {
        initMocks(this);
        this.controller = new BooksController(bookRepository);
    }

    @Test
    public void shouldReturnAllPredefinedBooks() {
        when(bookRepository.all()).thenReturn(predefinedBooks());

        List<Book> books = controller.listBooks();

        assertThat(books.size(), is(predefinedBooks().size()));

        verify(bookRepository).all();
    }

    private List<Book> predefinedBooks() {
        Book firstBook = new Book(1, "The Book Test 1", "Author 1", "1999");
        Book secondBook = new Book(2,"The Book Test 2", "Author 2", "1999");

        List<Book> books = new ArrayList<>();
        books.add(firstBook);
        books.add(secondBook);
        return books;
    }
}
