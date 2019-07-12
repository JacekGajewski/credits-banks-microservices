package com.example.credit.model;

import javax.persistence.*;

@Entity
@Table(name = "Credit")
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "credit_id")
    private int creditId;

    @Column(name = "credit_name")
    private String creditName;

    public Credit() {
    }

    public Credit(String creditName) {
        this.creditName = creditName;
    }

    public int getCreditId() {
        return creditId;
    }

    public void setCreditId(int creditId) {
        this.creditId = creditId;
    }

    public String getCreditName() {
        return creditName;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }
}
