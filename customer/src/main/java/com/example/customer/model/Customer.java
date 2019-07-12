package com.example.customer.model;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "surname")
    private String surname;

    @Column(name = "PESEL")
    private String PESEL;

    @Column(name = "product_id")
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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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
