package com.example.linkedinsamarakkody.jakarta;



import com.example.linkedinsamarakkody.jakarta.entities.Author;
import com.example.linkedinsamarakkody.jakarta.entities.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_persistence_unit");
        oneToOneRelationship(emf);
    }

    private static void oneToOneRelationship (EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Book book = new Book();

            book.setName("another book");
            book.setIsbn("1010-111");

            Author author = new Author();
            author.setName("John");
            book.setAuthor(author);

            em.persist(book);
            em.persist(author);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}



