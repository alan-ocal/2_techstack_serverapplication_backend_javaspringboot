package com.example.linkedinsamarakkody.jakarta.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "field")
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "field_id")
    private int id;

    @Column(name = "field_name")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "field_category", joinColumns = @JoinColumn(name = "field_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}

