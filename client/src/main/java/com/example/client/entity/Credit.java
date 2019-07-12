package com.example.client.entity;

public class Credit {

    private int creditId;

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
