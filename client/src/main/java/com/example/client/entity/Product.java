package com.example.client.entity;

public class Product {

    private int productId;

    private String productName;

    private int value;

    private int credit_id;

    public Product() {
    }

    public Product(String productName, int credit_id) {
        this.productName = productName;
        this.credit_id = credit_id;
    }

    public Product(String productName, int value, int credit_id) {
        this.productName = productName;
        this.value = value;
        this.credit_id = credit_id;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getCredit_id() {
        return credit_id;
    }

    public void setCredit_id(int credit_id) {
        this.credit_id = credit_id;
    }
}
