package br.com.library.controllers;

import br.com.library.models.Book;
import br.com.library.repositories.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BooksController {

    private Books books;

    @Autowired
    public BooksController(Books books) {
        this.books = books;
    }

    @RequestMapping("/books-list")
    public List<Book> listBooks() {
        this.books.createPredefinedBooks();

        return this.books.all();
    }
}
