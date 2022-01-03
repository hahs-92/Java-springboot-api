package com.platzi.market.persistence.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@SuperBuilder
@Entity
@Table(name = "productos") //productos -> nombre de la tabla en la DB
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProduct;

    @Column(name = "nombre")
    private String name;

    @Column(name = "id_categoria")
    private Integer idCategory;

    @Column(name = "codigo_barras")
    private String barCode;

    @Column(name = "precio_venta")
    private  Double salePrice;

    @Column(name = "cantidad_stock")
    private Integer stock;

    @Column(name = "estado")
    private Boolean status;

    //relaciones
    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false) // false -> no se creara o inserta una ctg, solo es para saber en q ctg pertenece un producto
    private CategoryEntity category;

    //no se realizo la relacion con compras- productos

}


