package com.platzi.market.persistence;

import com.platzi.market.persistence.crud.ProductCrudRepository;
import com.platzi.market.persistence.entity.Product;

import java.util.List;

public class ProductRepository {
    private ProductCrudRepository productCrudRepository;

    //metodos
    public List<Product> getAll() {
        return (List<Product>) productCrudRepository.findAll();
    }
}
