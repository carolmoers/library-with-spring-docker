package br.com.library.controllers;

import br.com.library.models.Book;
import br.com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BooksController {

    private BookRepository books;

    @Autowired
    public BooksController(BookRepository booksRepository) {
        this.books = booksRepository;
    }

    @RequestMapping("/books-list")
    public List<Book> listBooks() {
        this.books.createPredefinedBooks();

        return this.books.all();
    }
}
