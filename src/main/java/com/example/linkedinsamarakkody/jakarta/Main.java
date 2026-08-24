package com.example.linkedinsamarakkody.jakarta;



import com.example.linkedinsamarakkody.jakarta.entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("artclass_persistence_unit");

//  create(emf);
//  update(emf);
// attachAndDetach(emf);
//   remove(emf);
    }

    private static void create(EntityManagerFactory emf){
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Student student = new Student();
            student.setStudent_name("John");

            em.persist(student);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    private static void update(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Student student = em.find(Student.class, 3);
            student.setStudent_name("Peter");
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    private static void attachAndDetach(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Student student2 = new Student();
            student2.setStudent_name("Pery");
            em.merge(student2);
            em.detach(student2);
            student2.setStudent_name("Sue"); //it doesn't work
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    private static void remove(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Student student = em.find(Student.class, 3);
            em.remove(student);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}



