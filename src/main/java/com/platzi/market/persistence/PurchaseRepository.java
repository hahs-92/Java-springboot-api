package com.platzi.market.persistence;

import com.platzi.market.domain.Purchase;
import com.platzi.market.domain.repository.IPurchaseRepository;
import com.platzi.market.persistence.crud.IPurchaseCrudRepository;
import com.platzi.market.persistence.entity.PurchaseEntity;
import com.platzi.market.persistence.mapper.IPurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepository implements IPurchaseRepository {
    private IPurchaseCrudRepository iPurchaseCrudRepository;
    private IPurchaseMapper mapper;

    @Autowired
    public PurchaseRepository(IPurchaseCrudRepository iPurchaseCrudRepository, IPurchaseMapper mapper) {
        this.iPurchaseCrudRepository = iPurchaseCrudRepository;
        this.mapper = mapper;
    }


    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<PurchaseEntity>) iPurchaseCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClientId(String clientId) {
        return iPurchaseCrudRepository.findByIdClient(clientId)
                .map(purchase -> mapper.toPurchases(purchase));
    }

    @Override
    public Purchase save(Purchase purchase) {
        PurchaseEntity purchaseEntity = mapper.toPurchaseEntity(purchase);
        //guardar en cascada
        // 1 se debe aseguarar que purchase conoce los productos
        // 2 los products conocen a que compra pertenecen
        purchaseEntity.getProducts()
                .forEach(p -> p.setPurchase(purchaseEntity));

        return mapper.toPurchase(iPurchaseCrudRepository.save(purchaseEntity));
    }
}
