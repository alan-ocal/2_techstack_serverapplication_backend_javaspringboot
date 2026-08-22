package com.example.linkedinsamarakkody.jakarta;


import com.example.linkedinsamarakkody.jakarta.entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class
Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("artclass_persistence_unit");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        try {
           tx.begin();
           Student student = new Student();
           student.setStudent_name("John");

           em.persist(student);
           tx.commit();

           }catch (Exception e) {
           e.printStackTrace();

            }finally {
            em.close();
            }
        }
}
