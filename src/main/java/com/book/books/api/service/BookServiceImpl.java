package com.book.books.api.service;

import com.book.books.api.model.Book;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author alberto
 */
@Service
public class BookServiceImpl implements BookService
{
    private List<Book> books = new ArrayList<>();

    public BookServiceImpl() {
        // Sample data for books
        books.add(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
        books.add(new Book(2, "1984", "George Orwell"));
        books.add(new Book(3, "To Kill a Mockingbird", "Harper Lee"));
        books.add(new Book(4, "The Goofather", "Mario Puzo"));
        books.add(new Book(5, "Scarface", "Howard Hawks"));
    }

    @Override
    public List<Book> findAllBooks() 
    {
        return books;
    }

    @Override
    public Book findBookById(int id) 
    {
        return books.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void deleteAllBooks() 
    {
        books.clear();
    }

    @Override
    public Book deleteBookById(int id) 
    {
        Book book = books.remove(id);
        return book;
    }

}
