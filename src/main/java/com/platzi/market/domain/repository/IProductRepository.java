package com.platzi.market.domain.repository;

import com.platzi.market.domain.Product;

import java.util.List;
import java.util.Optional;

public interface IProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByIdCategory(int categoryId);
    //Optional<List<Product>> getByCategoryOrderByNameAsc(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct(int productId);
    Product saveProduct(Product product);
    void deleteProduct(int productId);
}
