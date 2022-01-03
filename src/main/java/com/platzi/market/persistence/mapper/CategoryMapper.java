package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Category;
import com.platzi.market.persistence.entity.CategoryEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring") //interacion con spring
public interface CategoryMapper {
    //mappers
    @Mappings({
            @Mapping(source = "idCategory", target = "id"),
            @Mapping(source = "description", target = "category"),
            @Mapping(source = "status", target = "active"),
    })
    Category toCategoryEntity(CategoryEntity categoryEntity);

    @InheritInverseConfiguration //inversa de lo de arriba
    @Mapping(target = "products", ignore = true) //no vamos a mapear products
    CategoryEntity toCategory(Category category);
}
