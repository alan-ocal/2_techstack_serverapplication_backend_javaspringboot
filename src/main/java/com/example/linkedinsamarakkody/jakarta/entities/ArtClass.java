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


    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getDay_of_week() {
        return day_of_week;
    }

    public void setDay_of_week(String day_of_week) {
        this.day_of_week = day_of_week;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }
}