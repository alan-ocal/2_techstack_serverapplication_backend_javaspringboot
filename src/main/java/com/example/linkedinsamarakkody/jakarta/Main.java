package com.example.linkedinsamarakkody.jakarta;

import com.example.linkedinsamarakkody.jakarta.entities.BookType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_persistence_unit");
        try {
            aggregateFunctions(emf);
        } finally {
            emf.close();
        }
    }

    private static void aggregateFunctions(EntityManagerFactory emf) {
        try{
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            //---------COUNT() function---------
//            String s = "SELECT COUNT(b) FROM Book b WHERE b.author.name = :name";
//            Query query = em.createQuery(s);
//            query.setParameter("name", "Allen");
//            Long numberOfBooks = (Long) query.getSingleResult();
//            System.out.println("Number of book of author is: " + numberOfBooks);

            //---------SUM() function---------
//            String s = "SELECT SUM(b.price) FROM Book b WHERE b.author.name = :name";
//            TypedQuery<Double> query = em.createQuery(s, Double.class);
//            query.setParameter("name", "Jane");
//            BigDecimal totalCost = BigDecimal.valueOf(query.getSingleResult());
//            System.out.println("Total cost of books of author: " + totalCost);

            //---------MIN() function---------
//            String s = "SELECT MIN(r.rating) FROM Review r WHERE r.book.name = :name";
//            TypedQuery<Integer> query = em.createQuery(s, Integer.class);
//            query.setParameter("name", "Book1");
//            int minRating = query.getSingleResult();
//            System.out.println("Minimum rating for book: " + minRating);

            //---------MAX() function---------
//            String s = "SELECT MAX(r.rating) FROM Review r WHERE r.book.name = :name";
//            TypedQuery<Integer> query = em.createQuery(s, Integer.class);
//            query.setParameter("name", "Book1");
//            int maxRating = query.getSingleResult();
//            System.out.println("Maximum rating for book: " + maxRating);

            //---------AVG() function---------
            String s = "SELECT AVG(r.rating) FROM Review r WHERE r.book.name = :name";
            TypedQuery<Double> query = em.createQuery(s, Double.class);
            query.setParameter("name", "Book1");
            Double avgRating = query.getSingleResult();
            System.out.println("Average rating for book: " + avgRating);
            em.getTransaction().commit();

        } finally {
        emf.close();
    }







    }


}



