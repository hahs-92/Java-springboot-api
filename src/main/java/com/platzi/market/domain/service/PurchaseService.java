package com.platzi.market.domain.service;

import com.platzi.market.domain.Purchase;
import com.platzi.market.domain.repository.IPurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    private final IPurchaseRepository iPurchaseRepository;

    @Autowired
    public PurchaseService(IPurchaseRepository iPurchaseRepository) {
        this.iPurchaseRepository = iPurchaseRepository;
    }

    public List<Purchase> getAll() {
        return iPurchaseRepository.getAll();
    }

    public Optional<List<Purchase>> getByClientId(String clientId) {
        return iPurchaseRepository.getByClientId(clientId);
    }

    public Purchase save(Purchase purchase) {
        return iPurchaseRepository.save(purchase);
    }
}
