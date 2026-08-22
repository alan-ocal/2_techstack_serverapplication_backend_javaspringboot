package com.example.linkedinsamarakkody.jakarta.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "class")
public class ArtClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private Integer class_id;

    @Column(name = "class_name")
    private String class_name;

    @Column(name = "day_of_week")
    private String day_of_week;

    @Column (name = "teacher_id")
    private Integer teacher_id;

}
