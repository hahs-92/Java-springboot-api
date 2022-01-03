package com.platzi.market.web.controller;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Product> getAll() {
        return service.getAll();
    }

    public Optional<Product> getProduct(int productId) {
        return  service.getProduct(productId);
    }

    public Optional<List<Product>> getByIdCategory(int categoryId) {
        return service.getByIdCategory(categoryId);
    }

    public Product save(Product product) {
        return service.save(product);
    }

    public boolean delete(int productId) {
        return service.delete(productId);
    }
}
