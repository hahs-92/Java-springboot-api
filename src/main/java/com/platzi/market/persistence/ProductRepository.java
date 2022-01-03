package com.platzi.market.persistence;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.IProductRepository;
import com.platzi.market.persistence.crud.IProductCrudRepository;
import com.platzi.market.persistence.entity.ProductEntity;
import com.platzi.market.persistence.mapper.IProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements IProductRepository {
    private final IProductCrudRepository iProductCrudRepository;
    private final IProductMapper mapper;

    @Autowired //inyeccion de dependencias
    public ProductRepository(IProductCrudRepository iProductCrudRepository, IProductMapper mapper) {
        this.iProductCrudRepository = iProductCrudRepository;
        this.mapper = mapper;
    }

    //metodos enfocados al domain y no la entidad gracias a mapper
    @Override
    public List<Product> getAll() {
        List<ProductEntity> products = (List<ProductEntity>) iProductCrudRepository.findAll();
        return mapper.toProducts(products);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<ProductEntity> products = iProductCrudRepository.findIdCategory(categoryId);
        return Optional.of(mapper.toProducts(products));
    }

    @Override
    public Optional<List<Product>> getByCategoryOrderByNameAsc(int categoryId) {
        List<ProductEntity> products = iProductCrudRepository.findIdCategoryOrderByNameAsc(categoryId);
        return Optional.of(mapper.toProducts(products));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<ProductEntity>> products = iProductCrudRepository.findByStockLessThanAndStatus(quantity, true);
        return products.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int idProduct) {
        return iProductCrudRepository.findById(idProduct).map(prod -> mapper.toProduct(prod));
    }

    @Override
    public Product saveProduct(Product product) {
        ProductEntity productEntity = mapper.toProductEntity(product);
        return mapper.toProduct(iProductCrudRepository.save(productEntity));
    }

    @Override
    public void deleteProduct(int productId) {
        iProductCrudRepository.deleteById(productId);
    }
}
