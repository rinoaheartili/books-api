package com.book.books.api.model;

/**
 *
 * @author alberto
 */
public class Book 
{
    private int id;
    private String title;
    private String author;

    public Book() 
    {
    }

    public Book(int id, String title, String author)
    {
        this.id = id;
        this.title = title;
        this.author = author;
    }
    
    // Getters and Setters
    public int getId() 
    { 
        return id; 
    }
    
    public void setId(int id) 
    { 
        this.id = id; 
    }

    public String getTitle() 
    { 
        return title; 
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getAuthor() 
    { 
        return author; 
    }
    
    public void setAuthor(String author)
    {
        this.author = author;
    }

    @Override
    public int hashCode() 
    {
        int hash = 3;
        hash = 23 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() 
    {
        return "Book[" + "id=" + id + ", title=" + title + ", author=" + author + ']';
    }
    
}
