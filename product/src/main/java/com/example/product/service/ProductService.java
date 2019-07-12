package com.example.product.service;

import com.example.product.model.Product;

import java.util.List;

public interface ProductService {

    Product findById(int id);

    List<Product> findAll();

    void save(Product product);

    void update(Product theProduct);

    void delete(int id);

}
