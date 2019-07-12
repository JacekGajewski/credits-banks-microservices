package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    DiscoveryClient discoveryClient;

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products/{id}")
    @ResponseBody
    public Product getProduct(@PathVariable int id){
        return productService.findById(id);
    }

    @GetMapping("/products")
    @ResponseBody
    public List<Product> getProducts(){
        return productService.findAll();
    }

    @PostMapping("/products")
    public void createProduct(@RequestBody Product product){
        productService.save(product);
    }

    @PutMapping("/products")
    public void updateProduct(@RequestBody Product product){
        productService.update(product);
    }

    @DeleteMapping("products/{id}")
    public void deleteProduct(@PathVariable int id){
        productService.delete(id);
    }
}
