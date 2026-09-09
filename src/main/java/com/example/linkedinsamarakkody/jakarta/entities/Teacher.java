package com.example.linkedinsamarakkody.jakarta.entities;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table (name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Integer teacher_id;

    @Column(name = "teacher_name")
    private String teacher_name;

     @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Review> reviews;

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}