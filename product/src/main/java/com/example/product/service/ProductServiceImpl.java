package com.example.product.service;

import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product findById(int id) {
        Optional<Product> product = productRepository.findById(id);

        Product theProduct = null;

        if (product.isPresent()){
            theProduct = product.get();
        }
        else {
            throw new RuntimeException("Did not find product id - " + id);
        }

        return theProduct;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void update(Product theProduct) {
        Product product = productRepository.getOne(theProduct.getProductId());

        product.setProductName(theProduct.getProductName());
        product.setValue(theProduct.getValue());

        productRepository.save(product);
    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }
}
