package com.example.linkedinsamarakkody.jakarta;


import com.example.linkedinsamarakkody.jakarta.entities.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class
Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_persistence_unit");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Book book = new Book();
            book.setName("my book");
            book.setIsbn("123-456");

            em.persist(book);
            tx.commit();

            }catch (Exception e) {
            e.printStackTrace();

            }finally {
                em.close();
            }
        }
}
