package com.example.linkedinsamarakkody.jakarta.entities;

import com.example.linkedinsamarakkody.jakarta.entities.Author;
import jakarta.persistence.*;

import java.util.List;

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

    // one to one relationship
    @OneToOne
    @JoinColumn(name = "author_id")
    private Author author;

    // Cascading is the mechanism that allows you to perform operations
    // on related entities when performing operations on the parent entity.
    @OneToMany (mappedBy = "book", cascade = CascadeType.ALL)
    private List<Review> reviews;


    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}