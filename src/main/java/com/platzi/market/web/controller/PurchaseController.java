package com.platzi.market.web.controller;

import com.platzi.market.domain.Purchase;
import com.platzi.market.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Purchase>> getAll() {
        try {
            return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
        } catch (RuntimeException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("client/{clientId}")
    public ResponseEntity<List<Purchase>> getByClient(@PathVariable String clientId) {
        try {
            return purchaseService.getByClientId(clientId)
                    .map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Purchase> save (@RequestBody Purchase purchase) {
        try {
            return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }
}
