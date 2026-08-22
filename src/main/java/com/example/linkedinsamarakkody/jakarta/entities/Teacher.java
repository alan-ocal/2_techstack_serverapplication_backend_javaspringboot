package com.example.linkedinsamarakkody.jakarta.entities;

import jakarta.persistence.*;


@Entity
@Table (name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Integer teacher_id;

    @Column
    private String teacher_name;
}
