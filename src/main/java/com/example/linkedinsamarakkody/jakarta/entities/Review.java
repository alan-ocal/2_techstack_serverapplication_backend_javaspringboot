package com.example.linkedinsamarakkody.jakarta.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Integer review_id;

    @Column(name = "teacher_id")
    private Integer teacher_id;

    @Column(name = "comment")
    private String comment;

    @Column
    private Integer rating;
}
