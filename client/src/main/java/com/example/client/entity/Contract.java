package com.example.client.entity;

public class Contract {

    private Customer customer;

    private Product product;

    private Credit credit;

    public Contract() {
    }

    public Contract(Customer customer) {
        this.customer = customer;
    }

    public Contract(Customer customer, Product product, Credit credit) {
        this.customer = customer;
        this.product = product;
        this.credit = credit;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }
}
