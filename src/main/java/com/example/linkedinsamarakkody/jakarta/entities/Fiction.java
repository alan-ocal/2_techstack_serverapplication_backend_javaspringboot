package com.example.linkedinsamarakkody.jakarta.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "fiction")
@PrimaryKeyJoinColumn
public class Fiction extends Genre {

    private String setting;

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }
}