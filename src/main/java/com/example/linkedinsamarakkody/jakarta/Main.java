package com.example.linkedinsamarakkody.jakarta;

import com.example.linkedinsamarakkody.jakarta.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("artclass_persistence_unit");
        try {
            //oneToOneRelationship(emf);
            //oneToManyRelationship(emf);
            manyToManyRelationship(emf);

        } finally {
            emf.close();
        }
    }

    private static void oneToOneRelationship(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            ArtClass artClass = new ArtClass();

            artClass.setClass_name("Oil Painting");
            artClass.setDay_of_week("Monday");

            Teacher teacher = new Teacher();
            teacher.setTeacher_name("Brown");

            artClass.setTeacher(teacher);
            em.persist(teacher);
            em.persist(artClass);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    private static void oneToManyRelationship(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Teacher teacher = new Teacher();
            teacher.setTeacher_name("Woods");

            Review review1 = new Review();
            review1.setComment("Excellent");
            review1.setRating(5);
            review1.setTeacher(teacher);

            Review review2 = new Review();
            review2.setComment("Good");
            review2.setRating(4);
            review2.setTeacher(teacher);

            teacher.setReviews(List.of(review1, review2));
            em.persist(teacher);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    private static void manyToManyRelationship(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            ArtClass artClass1 = new ArtClass();
            artClass1.setClass_name("Recycled Scrap Art");
            artClass1.setDay_of_week("Tuesday");

            ArtClass artClass2 = new ArtClass();
            artClass2.setClass_name("Drawing Hands");
            artClass2.setDay_of_week("Wednesday");

            Teacher teacher1 = new Teacher();
            teacher1.setTeacher_name("White");

            Teacher teacher2 = new Teacher();
            teacher2.setTeacher_name("Wood");

            artClass1.setTeacher(teacher1);
            artClass2.setTeacher(teacher2);

            Student student1 = new Student();
            student1.setStudent_name("Anne");
            Student student2 = new Student();
            student2.setStudent_name("Jack");

            artClass1.setStudents(List.of(student1, student2));
            artClass2.setStudents(List.of(student1, student2));

            em.persist(artClass1);
            em.persist(artClass2);
            em.getTransaction().commit();
        } finally {
            emf.close();
        }
    }
}




