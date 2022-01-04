package com.example.baitap1.service;

import com.example.baitap1.model.Product;
import org.springframework.stereotype.Service;


public interface ProductService {
    Iterable<Product> findAll();

    Product findById(Long id);

    void save(Product product);

    void remove(Long id);
}
