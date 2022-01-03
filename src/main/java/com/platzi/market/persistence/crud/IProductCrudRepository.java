package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

//<> la clase(entity) y el tipo de variable que sea el ID
public interface IProductCrudRepository extends CrudRepository<ProductEntity, Integer> {
    //QUERY METHODS
    //idCategory es la variable en Productos por la que quremos buscar
    //por eso el nombre del metodo
    List<ProductEntity> findIdCategory(int idCategory);

    /*
    //tambien se podria hacer con la anotacion @Query
    @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
    List<Product> getByCategoryId(int idCategory); // aqui se puede llama el metofo como queramos
     */

    List<ProductEntity> findIdCategoryOrderByNameAsc(int idCategory);

    Optional<List<ProductEntity>> findByStockLessThanAndStatus(int stock, boolean status);

}
