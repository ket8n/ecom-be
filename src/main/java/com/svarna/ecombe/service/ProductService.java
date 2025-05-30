package com.svarna.ecombe.service;

import com.svarna.ecombe.model.Product;
import com.svarna.ecombe.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepo productRepo;

    ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> getAllProducts() {
        return this.productRepo.findAll();
    }

    public Product addProduct(Product product) {
        return this.productRepo.save(product);
    }

    public Product getProductById(int id) {
        return this.productRepo.findById(id).orElse(null);
    }
}
