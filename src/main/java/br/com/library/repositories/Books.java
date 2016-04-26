package br.com.library.repositories;

import br.com.library.models.Book;

import java.util.ArrayList;
import java.util.List;

public class Books {
    private List<Book> books;

    public Books() {
        this.books = new ArrayList<Book>();
    }

    public List<Book> all() {
        return this.books;
    }

    public List<Book> createPredefinedBooks(){
        Book firstBook = new Book(1, "The Pragmatic Programmer", "Andrew Hunt, David Thomas", "1999");
        this.books.add(firstBook);
        Book secondBook = new Book(2, "Head First Java", "Kathy Sierra, Bert Bates", "2005");
        this.books.add(secondBook);
        Book thirdBook = new Book(3, "Test-driven Development", "Kent Beck", "2003");
        this.books.add(thirdBook);

        return this.books;
    }
}
