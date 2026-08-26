package com.example.linkedinsamarakkody.jakarta;



import com.example.linkedinsamarakkody.jakarta.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_persistence_unit");
        //oneToManyRelationship(emf);
        manyToManyRelationship(emf);
    }

    private static void manyToManyRelationship (EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            User user1 = new User();
            user1.setName("User1");
            User user2 = new User();
            user2.setName("User2");

            Group group1 = new Group();
            group1.setName("Group1");
            Group group2 = new Group();
            group2.setName("Group2");

            group1.setUsers(List.of(user1, user2));
            group2.setUsers(List.of(user1));

            em.persist(group1);
            em.persist(group2);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    private static void oneToManyRelationship (EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Book book = new Book();

            book.setName("book 123");
            book.setIsbn("123-123");

            Author author = em.find(Author.class, 1);
            book.setAuthor(author);

            Review review1 = new Review();
            review1.setComment("This book is good");
            review1.setBook(book);

            Review review2 = new Review();
            review2.setComment("This book is lovely");
            review2.setBook(book);
            book.setReviews(List.of(review1, review2));

            em.persist(book);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}



