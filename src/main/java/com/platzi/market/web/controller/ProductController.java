package com.platzi.market.web.controller;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{productId}")
    public Optional<Product> getProduct(@PathVariable int productId) {
        return  service.getProduct(productId);
    }

    @GetMapping("/category/{categoryId}")
    public Optional<List<Product>> getByIdCategory(@PathVariable int categoryId) {
        return service.getByIdCategory(categoryId);
    }

    @PostMapping("/")
    public Product save(@RequestBody Product product) {
        return service.save(product);
    }

    @DeleteMapping("/{productId}")
    public boolean delete(@PathVariable int productId) {
        return service.delete(productId);
    }
}
