package com.platzi.market.persistence;

import com.platzi.market.persistence.crud.ProductCrudRepository;
import com.platzi.market.persistence.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    private ProductCrudRepository productCrudRepository;

    //metodos
    public List<Product> getAll() {
        return (List<Product>) productCrudRepository.findAll();
    }

    public List<Product> getByCategory(int idCategoria) {
        return productCrudRepository.findIdCategory(idCategoria);
    }

    public List<Product> getByCategoryOrderByNameAsc(int idCategoria) {
        return productCrudRepository.findIdCategoryOrderByNameAsc(idCategoria);
    }

    public Optional<List<Product>> getProductScarce(int stock) {
        return productCrudRepository.findByStockLessThanAndStatus(stock, true);
    }

    public Optional<Product> getProduct(int idProduct) {
        return productCrudRepository.findById(idProduct);
    }

    public Product saveProduct(Product product) {
        return productCrudRepository.save(product);
    }

    public void deleteProduct(int idProduct) {
        productCrudRepository.deleteById(idProduct);
    }
}
