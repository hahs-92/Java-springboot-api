package com.platzi.market.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "compras_productos")
public class PurchasesProduct {
    @EmbeddedId
    private PurchasesProductPK id;

    @Column(name = "cantidad")
    private Integer quantity;

    private  Double total;

    @Column(name = "estado")
    private Boolean status;

}
