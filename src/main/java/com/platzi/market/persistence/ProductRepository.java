package com.platzi.market.persistence;

import com.platzi.market.persistence.crud.ProductCrudRepository;
import com.platzi.market.persistence.entity.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    private ProductCrudRepository productCrudRepository;

    //metodos
    public List<ProductEntity> getAll() {
        return (List<ProductEntity>) productCrudRepository.findAll();
    }

    public List<ProductEntity> getByCategory(int idCategoria) {
        return productCrudRepository.findIdCategory(idCategoria);
    }

    public List<ProductEntity> getByCategoryOrderByNameAsc(int idCategoria) {
        return productCrudRepository.findIdCategoryOrderByNameAsc(idCategoria);
    }

    public Optional<List<ProductEntity>> getScarceProducts(int stock) {
        return productCrudRepository.findByStockLessThanAndStatus(stock, true);
    }

    public Optional<ProductEntity> getProduct(int idProduct) {
        return productCrudRepository.findById(idProduct);
    }

    public ProductEntity saveProduct(ProductEntity product) {
        return productCrudRepository.save(product);
    }

    public void deleteProduct(int idProduct) {
        productCrudRepository.deleteById(idProduct);
    }
}
