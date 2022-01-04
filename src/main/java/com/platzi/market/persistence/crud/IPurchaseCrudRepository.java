package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.PurchaseEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IPurchaseCrudRepository extends CrudRepository<PurchaseEntity, Integer> {
    //querymethods
    Optional<List<PurchaseEntity>> findByIdClient(String clientId);
}
