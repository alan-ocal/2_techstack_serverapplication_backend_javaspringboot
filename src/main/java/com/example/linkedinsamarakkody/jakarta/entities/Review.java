package com.example.linkedinsamarakkody.jakarta.entities;

import com.example.linkedinsamarakkody.jakarta.entities.Book;
import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private int id;

    private String comment;

     @ManyToOne
    // The @JoinColumn annotation is used to specify the foreign key column
    // in the review table that references the book table.
    @JoinColumn(name = "book_id")
    private Book book;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Review [id=" + id + ", comment=" + comment + "]";
    }
}
