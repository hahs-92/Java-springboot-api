package com.platzi.market.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Setter
@Getter
@Embeddable // esta clase se utilizara para la llave compuesta
public class PurchasesProductPK implements Serializable {
    @Column(name = "id_compra")
    private Integer idPurchase;

    @Column(name = "id_producto")
    private Integer idProduct;
}
