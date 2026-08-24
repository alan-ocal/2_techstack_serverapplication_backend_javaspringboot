package com.example.linkedinsamarakkody.jakarta.entities.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

//this annotation is used to embed the key into the entity class as an instance
@Embeddable
public class ItemKey implements Serializable {

    @Column(name = "item_code")
    private String code;

    @Column(name = "item_number")
    private int number;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ItemKey itemKey = (ItemKey) o;
        return Objects.equals(code, itemKey.code) && Objects.equals(number, itemKey.number);
    }

    @Override
    public String toString() {
        return "ItemKey{" +
                "code='" + code + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
