package com.platzi.market.domain.service;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.IProductRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final IProductRepository iProductRepository;

    public ProductService(IProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }

    public List<Product> getAll() {
        return iProductRepository.getAll();
    }

    public Optional<Product> getProduct(int productId) {
        return iProductRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId) {
        return iProductRepository.getByCategory(categoryId);
    }

    public Product save(Product product) {
        return iProductRepository.saveProduct(product);
    }

    public boolean delete(int productId) {
        try {
            iProductRepository.deleteProduct(productId);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
        //verificar si existe el producto
        //retorna true si lo encontro y elimino o false si no
        /*
        return getProduct(productId).map(prod -> {
            iProductRepository.deleteProduct(productId);
            return true;
        }).orElse(false);

        //otra forma
        if(getProduct(productId).isPresent()) {
            iProductRepository.deleteProduct(productId);
            return  true;
        } else {
            return false;
        }
         */
    }
}
