package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.PurchaseItem;
import com.platzi.market.persistence.entity.PurchasesProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

//spring -> asi lo podemos inyectar desde otros lugares
@Mapper(componentModel = "spring")
public interface IPurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.idProduct", target = "productId"),
            @Mapping(source = "status", target = "active"),
    })
    PurchaseItem toPurchaseItem(PurchasesProductEntity product);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "id.idPurchase", ignore = true),
            @Mapping(target = "purchase", ignore = true),
            @Mapping(target = "product", ignore = true)
    })
    PurchasesProductEntity toPurchaseProductEntity( PurchaseItem item);
}
