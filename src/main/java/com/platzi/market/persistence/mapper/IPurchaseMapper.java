package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Purchase;
import com.platzi.market.persistence.entity.PurchaseEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {IPurchaseItemMapper.class})
public interface IPurchaseMapper {
    @Mappings({
            @Mapping(source = "idPurchase", target = "id"),
            @Mapping(source = "idClient", target = "clientId"),
            @Mapping(source = "status", target = "state"),
            @Mapping(source = "products", target = "items")
    })
    Purchase toPurchase(PurchaseEntity purchaseEntity);

    //no necesita configuracion xq toma la anterior
    List<Purchase> toPurchases(List<PurchaseEntity> purchaseEntities);

    @InheritInverseConfiguration
    @Mapping(target = "client", ignore = true)
    PurchaseEntity toPurchaseEntity(Purchase purchase);
}
