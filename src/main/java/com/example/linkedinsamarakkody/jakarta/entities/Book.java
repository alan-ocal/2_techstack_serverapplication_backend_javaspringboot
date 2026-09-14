package com.example.linkedinsamarakkody.jakarta.entities;

import jakarta.persistence.*;

import javax.security.sasl.AuthorizeCallback;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "book_id")
    private int id;

    @Column (name = "book_name")
    private String name;
    private String isbn;
    private Double price;

    @ManyToOne
    @JoinColumn  (name = "author_id")
    private Author author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", name=" + name + ", isbn=" + isbn + "]";
    }
}