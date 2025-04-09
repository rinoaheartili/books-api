package com.book.books.api.restController;

import com.book.books.api.model.Book;
import com.book.books.api.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alberto
 */
@RestController
@RequestMapping("/apiBooks")
public class BooksController 
{
    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String home() 
    {
        return "Welcome to the Book API!";
    }

    @GetMapping("/findById/{id}")
    public Book findBookById(@PathVariable int id) 
    {
        return bookService.findBookById(id);
    }

    @GetMapping("/findAll")
    public List<Book> findAllBooks() 
    {
        return bookService.findAllBooks();
    }

    @DeleteMapping("/delete")
    public String deleteAllBooks() 
    {
        bookService.deleteAllBooks();
        return "All books have been deleted.";
    }
    
    @DeleteMapping("/delete/{id}")
    public Book deleteById(@PathVariable int id) 
    {
        return bookService.deleteBookById(id);
    }
    
}
