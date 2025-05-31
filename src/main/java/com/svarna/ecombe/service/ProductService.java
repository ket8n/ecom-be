package com.svarna.ecombe.service;

import com.svarna.ecombe.model.Product;
import com.svarna.ecombe.repo.ProductRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    public Product addProduct(Product product, MultipartFile productImage) throws IOException {
        product.setImageName(productImage.getOriginalFilename());
        product.setImageType(productImage.getContentType());
        product.setImageData(productImage.getBytes());
        return this.productRepo.save(product);
    }

    public Product getProductById(int id) {
        return this.productRepo.findById(id).orElse(null);
    }
}
