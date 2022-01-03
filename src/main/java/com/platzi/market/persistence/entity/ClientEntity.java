package com.platzi.market.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes")
public class ClientEntity {
    @Id
    private String id;

    @Column(name = "nombre")
    private String firstName;

    @Column(name = "apellidos")
    private String lastName;

    @Column(name = "celular")
    private Long phone;

    @Column(name = "direccion")
    private String address;

    //relaciones -> purchase
    @OneToMany(mappedBy = "client")
    private List<PurchaseEntity> purchases;
}
