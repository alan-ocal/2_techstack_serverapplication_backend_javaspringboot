package com.example.linkedinsamarakkody.jakarta;

import com.example.linkedinsamarakkody.jakarta.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_persistence_unit");
        try {
            //oneToManyRelationship(emf);
            //manyToManyRelationship(emf);
            //mappedSuperclassStrategy(emf);
            //singleTableStrategy(emf);
            //joinedTableStrategy(emf);
            //tablePerClassStrategy(emf);
            compositionWithAssociation(emf);
        } finally {
            emf.close();
        }
    }

    private static void compositionWithAssociation (EntityManagerFactory emf){
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Field f1 = new Field();
            f1.setName("Music");
            Field f2 = new Field();
            f2.setName("Art");

            Category c1 = new Category();
            c1.setName("History");
            Category c2 = new Category();
            c2.setName("New Advancements");

            // For each field, set the two categories, and for each category, set the two fields.
            f1.setCategories(Set.of(c1, c2));
            f2.setCategories(Set.of(c1, c2));

            c1.setFields(Set.of(f1, f2));
            c2.setFields(Set.of(f1, f2));

            em.persist(f1);
            em.persist(f2);

            em.getTransaction().commit();

            // Verify data
            System.out.println("--- Verification ---");
            List<Field> fields = em.createQuery("select f from Field f", Field.class).getResultList();
            System.out.println("Total fields found: " + fields.size());
            for (Field f : fields) {
                System.out.println("Field: " + f.getName() + ", Categories: " +
                        f.getCategories().stream().map(Category::getName).toList());
            }

            List<Category> categories = em.createQuery("select c from Category c", Category.class).getResultList();
            System.out.println("Total categories found: " + categories.size());
            for (Category c : categories) {
                System.out.println("Category: " + c.getName() + ", Fields: " +
                        c.getFields().stream().map(Field::getName).toList());
            }

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }

    }
    private static void tablePerClassStrategy (EntityManagerFactory emf){
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            CardPayment card = new CardPayment();
            card.setId(100);
            card.setAmount(1000);
            card.setCardNumber("1234 5678 5677 3456");

            CashPayment cash = new CashPayment();
            cash.setId(101);
            cash.setAmount(2000);
            cash.setCode("CA001");

            em.persist(card);
            em.persist(cash);

            em.getTransaction().commit();

            // Verify data
            List<Payment> payments = em.createQuery("select p from Payment p", Payment.class).getResultList();
            System.out.println("Total payments found: " + payments.size());
            for (Payment p : payments) {
                System.out.println("Payment: id=" + p.getId() + ", amount=" + p.getAmount() + ", type=" + p.getClass().getSimpleName());
            }
        } finally {
            em.close();
        }
    }

    private static void joinedTableStrategy (EntityManagerFactory emf){
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Fiction f = new Fiction();
            f.setCode("F001");
            f.setSetting("Forest");

            NonFiction nf = new NonFiction();
            nf.setCode("NF001");
            nf.setTopic("Science");

            em.persist(f);
            em.persist(nf);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    private static void singleTableStrategy (EntityManagerFactory emf){
        EntityManager em = emf.createEntityManager();

        try {
        em.getTransaction().begin();
        Student2 s2 = new Student2();
        s2.setName("John");
        s2.setStudentCode("S001");

        Teacher2 t2 = new Teacher2();
        t2.setName("David");
        t2.setTeacherCode("T001");

        em.persist(s2);
        em.persist(t2);
        em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    private static void  mappedSuperclassStrategy(EntityManagerFactory emf){
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Student s = new Student();
            s.setName("John");
            s.setStudentCode("S001");

            Teacher t = new Teacher();
            t.setName("David");
            t.setTeacherCode("T001");

            em.persist(s);
            em.persist(t);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
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



