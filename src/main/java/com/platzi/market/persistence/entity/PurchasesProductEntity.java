package com.platzi.market.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "compras_productos")
public class PurchasesProductEntity {
    @EmbeddedId
    private PurchasesProductPK id;

    @Column(name = "cantidad")
    private Integer quantity;

    private  Double total;

    @Column(name = "estado")
    private Boolean status;

    //relaciones
    @ManyToOne
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private PurchaseEntity purchase;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private ProductEntity product;

}
