package com.example.linkedinsamarakkody.jakarta;


import com.example.linkedinsamarakkody.jakarta.entities.Book;
import com.example.linkedinsamarakkody.jakarta.entities.BookType;
import com.example.linkedinsamarakkody.jakarta.entities.Item;
import com.example.linkedinsamarakkody.jakarta.entities.keys.ItemKey;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class
Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_persistence_unit");
        //detachAndReattachInstance(emf);
        //removeInstance(emf);
        //useGetReference(emf);
        //useRefresh(emf);
        createEntityWithComposedPK(emf);
    }

    private static void createEntityWithComposedPK(EntityManagerFactory emf){
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
//            BookType bookType = new BookType();
//            bookType.setCode("C001");
//            bookType.setSubCode("SC001");
//            bookType.setName("Fiction-Horror");
//            em.persist(bookType);

            ItemKey id = new ItemKey();
            id.setCode("ABC");
            id.setNumber(100);

            Item i = new Item();
            i.setId(id);
            i.setName("ABC-100");
            em.persist(i);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

//    private static void useRefresh(EntityManagerFactory emf) {
//        EntityManager em = emf.createEntityManager();
//        try {
//            em.getTransaction().begin();
//            Book book3 = em.find(Book.class, 3);
//            System.out.println(book3);
//            book3.setName("some book");
//            System.out.println("Before " + book3);
//            em.refresh(book3);
//            System.out.println("After " + book3);
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            em.close();
//        }
//    }
    //private static void useGetReference (EntityManagerFactory emf){
    //    EntityManager em = emf.createEntityManager();
    //        try {
    //            em.getTransaction().begin();
    //            //retrieve a row of data with a specified PK (lazily loading data from the database)
    //            Book book3 = em.getReference(Book.class, 3);
    //            System.out.println(book3);
    //            em.getTransaction().commit();
    //        }catch (Exception e) {
    //            e.printStackTrace();
    //        }finally {
    //            em.close();
    //        }
    //    }
    //}
    //private static void removeInstance(EntityManagerFactory emf){
    //    EntityManager em = emf.createEntityManager();
    //    try {
    //        em.getTransaction().begin();
    //        Book book1 = em.find(Book.class, 2);
    //        em.remove(book1);
    //        em.getTransaction().commit();
    //
    //    }catch (Exception e) {
    //        e.printStackTrace();
    //    }finally {
    //        em.close();
    //    }
    //
    //    }
    //}
    //    public static void detachAndReattachInstance(EntityManagerFactory emf){
    //        EntityManager em = emf.createEntityManager();
    //
    //          try {
    //          em.getTransaction().begin();
    //          Book book1 = new Book();
    //          book1.setId(2);
    //          book1.setName("my newest book");
    //          book1.setIsbn("123-456");
    //          em.merge(book1);
    //          em.detach(book1);
    //          //book1.setName("my newest book1"); //this LOC doesn't work and there should be no change in the database
    //          em.getTransaction().commit();
    //
    //            }catch (Exception e) {
    //                e.printStackTrace();
    //            }finally {
    //                em.close();
    //            }
    //        }
    //
    //    }

}