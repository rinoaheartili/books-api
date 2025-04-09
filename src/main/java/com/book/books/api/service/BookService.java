package com.book.books.api.service;

import com.book.books.api.model.Book;
import java.util.List;

/**
 *
 * @author alberto
 */
public interface BookService 
{
    List<Book> findAllBooks();
    Book findBookById(int id);
    void deleteAllBooks();
    Book deleteBookById(int id);
}
