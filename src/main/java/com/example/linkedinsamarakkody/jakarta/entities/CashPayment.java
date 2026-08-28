package com.example.linkedinsamarakkody.jakarta.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "cashpayment")
public class CashPayment extends Payment {
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
