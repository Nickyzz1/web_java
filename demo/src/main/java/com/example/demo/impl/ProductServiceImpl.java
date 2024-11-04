package com.example.demo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.services.ProductService;

public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll(); // Chama o método do repositório
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product); // Chama o método do repositório para salvar
    }

    @Override
    public List<Product> findProductsByName(String name) {
        return productRepository.findByName(name); // Chama o método personalizado do repositório
    }

    @Override
    public List<Product> findProductsUnderPrice(Double price) {
        return productRepository.findByPriceLessThan(price); // Chama o método personalizado do repositório
    }
}
