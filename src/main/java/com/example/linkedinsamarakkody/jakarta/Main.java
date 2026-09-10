package com.example.linkedinsamarakkody.jakarta;

import com.example.linkedinsamarakkody.jakarta.dto.BooksAndAuthors;
import com.example.linkedinsamarakkody.jakarta.entities.*;
import jakarta.persistence.*;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_persistence_unit");
        try {
            joinsWithJPQL(emf);
        } finally {
            emf.close();
        }
    }

    private static void joinsWithJPQL(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            //INNER JOIN
//            String s = """
//            SELECT NEW com.example.linkedinsamarakkody.jakarta.dto.BooksAndAuthors(book, author, author.address) FROM Book book INNER JOIN book.author author
//            """;
            //LEFT JOIN (brings null values)
            String s = """
            SELECT NEW com.example.linkedinsamarakkody.jakarta.dto.BooksAndAuthors(book, author, author.address) FROM Book book LEFT JOIN book.author author
            """;
            TypedQuery<BooksAndAuthors> query = em.createQuery(s, BooksAndAuthors.class);
            List<BooksAndAuthors> result = query.getResultList();
            for (BooksAndAuthors r : result) {
                System.out.println(r.book() + " " + r.author() + " "  + r.address());
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

}



