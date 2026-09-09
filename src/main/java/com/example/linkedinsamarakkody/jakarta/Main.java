package com.example.linkedinsamarakkody.jakarta;

import com.example.linkedinsamarakkody.jakarta.entities.*;
import jakarta.persistence.*;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_persistence_unit");
        try {
            writeJPQLQuery(emf);

        } finally {
            emf.close();
        }
    }

    private static void writeJPQLQuery(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            TypedQuery<BookType> query = em.createQuery("SELECT bt FROM BookType bt WHERE bt.subCode = :subCode AND bt.name LIKE :name", BookType.class);
            query.setParameter("subCode","SC001");
            query.setParameter("name", "Fiction%");

            List<BookType> bookTypes = query.getResultList();
            for (BookType bt : bookTypes) {
                System.out.println (bt.toString());
            }

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

}



