package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Product;
import com.platzi.market.persistence.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = { CategoryMapper.class}) //para convertir categoria en category use ese mapper
public interface ProductMapper {
    //no es necesario hacer el mapper con si los atributos tienen el mismo nombre
    //se podria omitir Mappings y agregar solo los Mapping
    @Mappings({
            @Mapping(source = "idProduct", target = "id"),
            @Mapping(source = "idCategory", target = "categoryId"),
            @Mapping(source = "salePrice", target = "price"),
            @Mapping(source = "status", target = "active"),
    })
    Product toProductEntity(ProductEntity productEntity);
    //no es necesario hacer el mapper xq ya se hizo arriba
    List<Product> toProductsEntity(List<ProductEntity> productsEntity);

    //tampoco es necesario el mapper xq ya se hizo arriba
    @InheritInverseConfiguration()
    @Mapping(target = "barCode", ignore = true) //no agregamos ese atributo en la conversion
    ProductEntity toProduct(Product product);

}
