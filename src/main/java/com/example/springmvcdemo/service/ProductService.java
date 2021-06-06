package com.example.springmvcdemo.service;

import com.example.springmvcdemo.component.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProductList();

    void saveOrUpdate(Product product);

    Product getProductById(Long id);

    void deleteById(Long id);
}
