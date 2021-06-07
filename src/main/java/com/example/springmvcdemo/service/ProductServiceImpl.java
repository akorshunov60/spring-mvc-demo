package com.example.springmvcdemo.service;

import com.example.springmvcdemo.component.Product;
import com.example.springmvcdemo.component.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProductList() {
        return productRepository.findAll();
//        return ProductRepository.getInstance().findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id);
//        return ProductRepository.getInstance().findById(id);
    }

    @Override
    public void saveOrUpdate(Product product) {
        productRepository.saveOrUpdate(product);
//        ProductRepository.getInstance().saveOrUpdate(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
//        ProductRepository.getInstance().deleteById(id);
    }
}
