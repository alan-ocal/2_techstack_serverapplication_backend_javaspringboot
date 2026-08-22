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
        findAndUpdateInstance(emf);
    }



    public static void createInstance(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        try {
           tx.begin();
           Book book = new Book();
           book.setName("my book4");
           book.setIsbn("333-457");

           em.persist(book);
           tx.commit();

           }catch (Exception e) {
           e.printStackTrace();

            }finally {
            em.close();
            }
        }

    public static void findAndUpdateInstance(EntityManagerFactory emf){
        EntityManager em = emf.createEntityManager();

        //When we did a defined by ID, a SELECT query had been generated and
        //the requested data was retrieved from the database. The retrieved data then
        // becomes available as an entity instance in the context
         try {
           em.getTransaction().begin();
          Book book1 = em.find(Book.class,4 );
          book1.setName("my new book");
          System.out.println(book1);
           em.getTransaction().commit();

            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                em.close();
            }
        }

    }

