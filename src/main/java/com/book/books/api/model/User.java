package com.book.books.api.model;

import java.util.Objects;

/**
 *
 * @author alberto
 */
public class User 
{
    private Integer id;
    private String usuario;
    private String contraseña;
    private String token;

    public User() 
    {
    }

    public User(Integer id, String usuario, String contraseña, String token) 
    {
        this.id = id;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.token = token;
    }

    public Integer getId() 
    {
        return id;
    }

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public String getUsuario() 
    {
        return usuario;
    }

    public void setUsuario(String usuario) 
    {
        this.usuario = usuario;
    }

    public String getContraseña() 
    {
        return contraseña;
    }

    public void setContraseña(String contraseña) 
    {
        this.contraseña = contraseña;
    }

    public String getToken() 
    {
        return token;
    }

    public void setToken(String token) 
    {
        this.token = token;
    }

    @Override
    public int hashCode() 
    {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final User other = (User) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "User[" + "id=" + id + ", usuario=" + usuario + ", contrase\u00f1a=" + contraseña + ", token=" + token + ']';
    }
    
}
