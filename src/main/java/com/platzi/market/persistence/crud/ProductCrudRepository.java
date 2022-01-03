package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

//<> la clase(entity) y el tipo de variable que sea el ID
public interface ProductCrudRepository extends CrudRepository<Product, Integer> {

}
