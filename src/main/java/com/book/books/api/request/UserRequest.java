package com.book.books.api.request;

/**
 *
 * @author alberto
 */
public class UserRequest 
{
    private String username;
    private String password;

    // Constructor
    public UserRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters y Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
