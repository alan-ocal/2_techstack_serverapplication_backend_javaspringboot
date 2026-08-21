package com.example.linkedinsamarakkody.jakarta;

import com.example.linkedinsamarakkody.jakarta.entity.Author;
import com.example.linkedinsamarakkody.jakarta.entity.Book;
import com.example.linkedinsamarakkody.jakarta.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class
Main {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Author author = new Author("J.K. Rowling");
            Book book = new Book("Harry Potter", "1234567890");

            em.persist(author);
            em.persist(book);

            tx.commit();
            System.out.println("Data saved successfully!");
            
            // Querying data
            em.createQuery("SELECT b FROM Book b", Book.class)
                    .getResultList()
                    .forEach(b -> System.out.println("Book found: " + b.getName() + " (ISBN: " + b.getIsbn() + ")"));

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
            JPAUtil.shutdown();
        }
    }
}
