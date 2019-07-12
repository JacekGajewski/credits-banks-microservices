package com.example.client.entity;


public class Customer {

    private int customerId;

    private String firstName;

    private String surname;

    private String PESEL;

    private int productId;

    public Customer() {
    }

    public Customer(String firstName, String surname, String PESEL) {
        this.firstName = firstName;
        this.surname = surname;
        this.PESEL = PESEL;
    }

    public Customer(String firstName, String PESEL, int productId) {
        this.firstName = firstName;
        this.PESEL = PESEL;
        this.productId = productId;
    }

    public Customer(String firstName, String surname, String PESEL, int productId) {
        this.firstName = firstName;
        this.surname = surname;
        this.PESEL = PESEL;
        this.productId = productId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
