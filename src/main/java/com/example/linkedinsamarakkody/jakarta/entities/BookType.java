package com.example.linkedinsamarakkody.jakarta.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(BookType.class)
@Table (name =  "book_type")
public class BookType implements Serializable {

    @Id
    @Column(name = "type_code")
    private String code;

    @Id
    @Column(name = "type_subcode")
    private String subCode;

    @Column(name = "type_name")
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BookType [code=" + code + ", subCode=" + subCode + ", name=" + name + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookType bookType = (BookType) o;
        return Objects.equals(code, bookType.code) && Objects.equals(subCode, bookType.subCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, subCode);
    }
}
